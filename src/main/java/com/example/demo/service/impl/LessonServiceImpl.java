package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.common.NotFoundException;
import com.example.demo.repo.DepartmentRepo;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.repo.GroupRepo;
import com.example.demo.repo.LessonRepo;
import com.example.demo.rest.dto.lesson.AddLessonRequest;
import com.example.demo.rest.dto.lesson.LessonDepartment;
import com.example.demo.rest.dto.lesson.LessonInfo;
import com.example.demo.service.DisciplineService;
import com.example.demo.service.LessonService;
import com.example.demo.utils.converters.lesson.LessonConverterFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LessonServiceImpl implements LessonService {

    private final DepartmentRepo departmentRepo;
    private final EmployeeRepo employeeRepo;
    private final GroupRepo groupRepo;
    private final LessonRepo lessonRepo;

    private final DisciplineService disciplineService;

    private final LessonConverterFactory lessonConverterFactory;

    @Override
    public ResponseEntity<List<LessonDepartment>> getSchedule() {
        List<Department> departments = departmentRepo.findAll();
        List<LessonDepartment> result = new ArrayList<>();

        for (Department department : departments) {
            List<LessonInfo> lessonsForDepartment = getLessonsForDepartment(department);

            result.add(new LessonDepartment(department.getName(), lessonsForDepartment));
        }

        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<LessonDepartment> getSchedule(Long departmentId) {
        Optional<Department> departmentFromDb = departmentRepo.findById(departmentId);

        if (departmentFromDb.isEmpty()) {
            throw new NotFoundException("Не удалось найти подразделение по id = " + departmentId);
        }

        Department department = departmentFromDb.get();
        List<LessonInfo> lessonsForDepartment = getLessonsForDepartment(department);

        return ResponseEntity.ok(new LessonDepartment(department.getName(), lessonsForDepartment));
    }

    @Override
    public LessonDepartment addLesson(AddLessonRequest request) {
        Discipline discipline = disciplineService.getById(request.getDisciplineId());
        Employee teacher = employeeRepo.findById(request.getTeacherId()).orElse(null);
        Group group = groupRepo.findById(request.getGroupId()).orElse(null);

        Lesson lesson = Lesson.builder()
                .dateStart(request.getDateBegin())
                .dateEnd(request.getDateEnd())
                .group(group)
                .teacher(teacher)
                .discipline(discipline)
                .room(request.getRoom())
                .build();
        lessonRepo.saveAndFlush(lesson);

        Department department = teacher.getDepartments().get(0);

        LessonDepartment lessonDepartment = new LessonDepartment();
        lessonDepartment.setDepartmentName(department.getName());
        lessonDepartment.setLessons(List.of(LessonInfo.builder()
                .teacherName(teacher.getFio())
                .dateStart(lesson.getDateStart())
                .dateEnd(lesson.getDateEnd())
                .room(request.getRoom())
                .groupName(group.getName())
                .disciplineName(discipline.getName())
                .build()));

        return lessonDepartment;
    }

    private List<LessonInfo> getLessonsForDepartment(Department department) {
        LinkedList<Lesson> futureEmployeeDepartmentLessons = new LinkedList<>();

        for (Employee employee : department.getEmployees()) {
            List<Lesson> employeeLessons = employee.getLessons();
            List<Lesson> employeeFutureLessons = new ArrayList<>();
            if (CollectionUtils.isEmpty(employeeLessons)) {
                continue;
            }

            LocalDateTime now = LocalDateTime.now();

            for (Lesson lesson : employeeLessons) {
                if (lesson.getDateStart().isAfter(now)) {
                    employeeFutureLessons.add(lesson);
                }
            }

            futureEmployeeDepartmentLessons.addAll(employeeFutureLessons);
        }

        return futureEmployeeDepartmentLessons.stream()
                .map(lesson -> lessonConverterFactory.getLessonInfoConverter().convert(lesson))
                .toList();
    }
}
