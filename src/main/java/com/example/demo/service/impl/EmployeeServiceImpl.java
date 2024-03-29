package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.entity.dictionaryEnum.AgeGroupEnum;
import com.example.demo.entity.dictionaryEnum.EmployeeTypeEnum;
import com.example.demo.exception.common.BadRequestException;
import com.example.demo.exception.common.NotFoundException;
import com.example.demo.repo.DisciplineRepo;
import com.example.demo.repo.EmployeeJobRepo;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.rest.dto.degree.NewDegreeRequest;
import com.example.demo.rest.dto.discipline.DisciplineDto;
import com.example.demo.rest.dto.employee.*;
import com.example.demo.service.*;
import com.example.demo.utils.converters.discipline.DisciplineConverterFactory;
import com.example.demo.utils.converters.employee.EmployeeConverterFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeJobRepo employeeJobRepo;
    private final DisciplineRepo disciplineRepo;

    private final EmployeeTypeService employeeTypeService;
    private final DegreeService degreeService;
    private final DisciplineService disciplineService;
    private final DepartmentService departmentService;

    private final EmployeeConverterFactory employeeConverterFactory;
    private final DisciplineConverterFactory disciplineConverterFactory;

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
        if (request.getContractExpireDate() == null) {
            throw new BadRequestException("Должна быть заполнена дата окончания контракта");
        }

        Employee employee = employeeConverterFactory.getAddEmployeeRequestConverter().convert(request);
        Department department = departmentService.getById(request.getDepartmentId());
        if (employee.getDepartments() == null) {
            employee.setDepartments(new ArrayList<>());
        }
        employee.getDepartments().add(department);

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
    public ResponseEntity<List<EmployeeFull>> findByFio(String fio) {
        List<EmployeeFull> result = getByFio(fio).stream()
                .map(employee -> employeeConverterFactory.getEmployeeFullConverter().convert(employee))
                .collect(Collectors.toList());


        return ResponseEntity.ok(result);
    }

    private List<Employee> getByFio(String fio) {
        List<Employee> employees = employeeRepo.findAllByFioContaining(fio);
        if (CollectionUtils.isEmpty(employees)) {
            throw new NotFoundException("Не найден сотрудник с ФИО " + fio);
        }

        return employees;
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
    public EmployeeFull getEmpById(Long employeeId) {
        return employeeConverterFactory.getEmployeeFullConverter().convert(getById(employeeId));
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
        if (request.getContractExpireDate() == null) {
            throw new BadRequestException("Должна быть заполнена дата окончания контракта");
        }

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
    public ResponseEntity<List<EmployeeDiscipline>> getEmployeeDisciplinesById(Long employeeId) {
        Employee employee = getById(employeeId);
        return ResponseEntity.ok(getDisciplines(employee));
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

    @Override
    public void addDiscipline(AddEmployeeDisciplineRequest request) {
        Employee employee = getById(request.getEmployeeId());
        Discipline discipline = disciplineService.getById(request.getDisciplineId());

        // Тупая проверка на то чтобы у нас не было ситуации когда у сотрудника эта дисциплина уже есть
        for (Discipline employeeDiscipline: employee.getDisciplines()) {
            if (Objects.equals(employeeDiscipline.getId(), discipline.getId())) {
                throw new BadRequestException("У сотрудника с id = " + discipline.getId() +
                        " уже есть дисциплина с id = " + discipline.getId());
            }
        }

        // Тут должна быть проверка на то что дисциплина относится к кафедре но похуй

        employee.getDisciplines().add(discipline);

        employeeRepo.save(employee);
    }

    private List<EmployeeDiscipline> getDisciplines(Employee employee) {
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

        return result;
    }

    @Override
    public List<Discipline> getAllExcludingEmployees(Employee employee) {
        return disciplineRepo.findAllByEmployeesNotContaining(employee);
    }

    @Override
    public List<DisciplineDto> getAllDtoExcludingEmployees(Employee employee) {
        return getAllExcludingEmployees(employee).stream()
                .map(discipline -> disciplineConverterFactory.getDisciplineDtoConverter().convert(discipline))
                .toList();
    }

    @Override
    public List<DisciplineDto> getAllDtoExcludingEmployees(Long employeeId) {
        Employee employee = getById(employeeId);
        return getAllDtoExcludingEmployees(employee);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class Pair<L, R> {
        private L left;
        private R right;
    }
}
