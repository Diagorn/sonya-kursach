package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.entity.dictionaryEnum.AgeGroupEnum;
import com.example.demo.entity.dictionaryEnum.EmployeeTypeEnum;
import com.example.demo.exception.common.BadRequestException;
import com.example.demo.exception.common.NotFoundException;
import com.example.demo.repo.EmployeeJobRepo;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.rest.dto.degree.NewDegreeRequest;
import com.example.demo.rest.dto.employee.AddEmployeeRequest;
import com.example.demo.rest.dto.employee.EditEmployeeRequest;
import com.example.demo.rest.dto.employee.EmployeeDiscipline;
import com.example.demo.rest.dto.employee.EmployeeFull;
import com.example.demo.service.*;
import com.example.demo.utils.converters.employee.EmployeeConverterFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeJobRepo employeeJobRepo;

    private final EmployeeTypeService employeeTypeService;
    private final DegreeService degreeService;
    private final DisciplineService disciplineService;

    private final EmployeeConverterFactory employeeConverterFactory;

    @Override
    public ResponseEntity<List<EmployeeFull>> getAll() {
        return ResponseEntity.ok().body(
                employeeRepo.findAll()
                        .stream()
                        .map(emp -> employeeConverterFactory.getEmployeeFullConverter().convert(emp))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<EmployeeFull> add(AddEmployeeRequest request) {
        Employee employee = employeeConverterFactory.getAddEmployeeRequestConverter().convert(request);

        EmployeeType type = employeeTypeService.findById(request.getCategoryId());
        employee.setEmployeeType(type);

        if (employee.getEmployeeJobs() == null) {
            employee.setEmployeeJobs(new ArrayList<>());
        }

        employee.getEmployeeJobs().add(EmployeeJob.builder()
                .dateStart(LocalDate.now())
                .dateEnd(null)
                .salary(BigDecimal.ZERO)
                .position("Сотрудник")
                .employee(employee)
                .organizationName("НИУ МЭИ")
                .build()
        );

        employee = employeeRepo.save(employee);
        employeeJobRepo.save(employee.getEmployeeJobs().get(0));

        log.info("Создан сотрудник с id = {}", employee.getId());
        return ResponseEntity.ok(employeeConverterFactory.getEmployeeFullConverter().convert(employee));
    }

    @Override
    public ResponseEntity<EmployeeFull> findByFio(String fio) {
        return ResponseEntity.ok(employeeConverterFactory.getEmployeeFullConverter().convert(getByFio(fio)));
    }

    private Employee getByFio(String fio) {
        Optional<Employee> employee = employeeRepo.findByFio(fio);
        if (employee.isEmpty()) {
            throw new NotFoundException("Не найден сотрудник с ФИО " + fio);
        }

        return employee.get();
    }

    @Override
    public ResponseEntity<List<EmployeeFull>> findAllWithContractEndingThisYear() {
        EmployeeType pps = employeeTypeService.findById(EmployeeTypeEnum.PPS.getId());

        // С текущей даты до 31 декабря
        List<Employee> employees = employeeRepo.findByEmployeeTypeAndContractExpireDateBetween(
                pps,
                LocalDate.now().minusDays(1),
                LocalDate.of(LocalDate.now().getYear() + 1, Month.JANUARY, 1)
        );

        return ResponseEntity.ok(
                employees.stream()
                        .map(emp -> employeeConverterFactory.getEmployeeFullConverter().convert(emp))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Employee getById(Long employeeId) {
        Optional<Employee> employee = employeeRepo.findById(employeeId);
        if (employee.isEmpty()) {
            throw new NotFoundException("Не удалось найти сотрудника с id = " + employeeId);
        }

        return employee.get();
    }

    @Override
    public void changeDegree(Long employeeId, NewDegreeRequest request) {
        Degree degree = degreeService.getById(request.getId());
        Employee employee = getById(employeeId);

        employee.setDegree(degree);
        employeeRepo.save(employee);
    }

    @Override
    public ResponseEntity<?> edit(EditEmployeeRequest request) {
        Employee employee = getById(request.getId());

        employee.setFio(request.getFio());
        employee.setDateOfBirth(request.getDateOfBirth());
        employee.setActive(request.isActive());
        employee.setPassportSerie(request.getPassportSerie());
        employee.setPassportNumber(request.getPassportNumber());
        employee.setPassportGiverOrgan(request.getPassportGivingOrgan());
        employee.setPassportDepCode(request.getPassportDepCode());
        employee.setRegistrationAddress(request.getRegistrationAddress());
        employee.setEmpRecordNum(request.getEmpRecordNum());
        employee.setEmpRecordDigital(request.isEmpRecordDigital());
        employee.setEmpRecordDateStart(request.getEmpRecordDateStart());
        employee.setContractNumber(request.getContractNumber());
        employee.setContractDate(request.getContractDate());
        employee.setContractExpireDate(request.getContractExpireDate());
        employee.setRank(request.getRank());

        employeeRepo.save(employee);
        log.info("Отредактирован сотрудник с id = {}", request.getId());

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> delete(Long employeeId) {
        employeeRepo.deleteById(employeeId);
        log.info("Удалён сотрудник с идентификатором {}", employeeId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<EmployeeDiscipline>> getEmployeeDisciplinesByFio(String employeeFio) {
        Employee employee = getByFio(employeeFio);
        return getDisciplines(employee);
    }

    @Override
    public ResponseEntity<List<EmployeeDiscipline>> getEmployeeDisciplinesById(Long employeeId) {
        Employee employee = getById(employeeId);
        return getDisciplines(employee);
    }

    @Override
    public ResponseEntity<List<EmployeeFull>> getAllByDegreeId(Long degreeId) {
        Degree degree = degreeService.getById(degreeId);
        List<EmployeeFull> result = employeeRepo.findAllByDegree(degree).stream()
                .map(employee -> employeeConverterFactory.getEmployeeFullConverter().convert(employee))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<EmployeeFull>> getAllByAgeGroup(int ageCode) {
        Optional<AgeGroupEnum> enumVal = AgeGroupEnum.findByCode(ageCode);
        if (enumVal.isEmpty()) {
            throw new BadRequestException("Неизвестная возрастная группа с кодом " + ageCode);
        }
        AgeGroupEnum ageGroup = enumVal.get();

        LocalDate from = LocalDate.now().minusYears(ageGroup.getEndAge());
        LocalDate to = LocalDate.now().minusYears(ageGroup.getBeginAge());

        List<EmployeeFull> result = employeeRepo.findAllByDateOfBirthBetween(from, to).stream()
                .map(emp -> employeeConverterFactory.getEmployeeFullConverter().convert(emp))
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    private ResponseEntity<List<EmployeeDiscipline>> getDisciplines(Employee employee) {
        List<Discipline> allDisciplines = disciplineService.getByEmployee(employee);

        Map<Long, List<String>> disciplineGroupsMap = allDisciplines.stream()
                .map(discipline -> new Pair<>(discipline.getId(),
                        discipline.getLessons().stream()
                                .map(lesson -> lesson.getGroup().getName())
                                .collect(Collectors.toList())
                        )
                )
                .collect(Collectors.toMap(Pair::getLeft, Pair::getRight));

        List<EmployeeDiscipline> result = allDisciplines.stream()
                .map(discipline -> EmployeeDiscipline.builder()
                        .employeeFio(employee.getFio())
                        .name(discipline.getName())
                        .departmentName(discipline.getDepartment().getName())
                        .groupNumbers(disciplineGroupsMap.get(discipline.getId()))
                        .build())
                .toList();

        return ResponseEntity.ok(result);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class Pair<L, R> {
        private L left;
        private R right;
    }
}
