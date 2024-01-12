package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    private Long id;
    @Column(name = "fio", nullable = false)
    private String fio;
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @Column(name = "passport_serie", nullable = false, length = 4)
    private String passportSerie;
    @Column(name = "passport_number", nullable = false, length = 6)
    private String passportNumber;
    @Column(name = "passport_giver_organ", nullable = false, length = 127)
    private String passportGiverOrgan;
    @Column(name = "passport_dep_code", nullable = false, length = 7)
    private String passportDepCode;
    @Column(name = "registration_address", nullable = false, length = 300)
    private String registrationAddress;
    @Column(name = "emp_record_num", nullable = false, length = 20)
    private String empRecordNum;
    @Column(name = "is_emp_record_digital", nullable = false)
    private boolean isEmpRecordDigital;
    @Column(name = "emp_record_date_start")
    private LocalDate empRecordDateStart;
    @Column(name = "contract_num", nullable = false, length = 30)
    private String contractNumber;
    @Column(name = "contract_date", nullable = false)
    private LocalDate contractDate;
    @Column(name = "contract_expire_date", nullable = false)
    private LocalDate contractExpireDate;
    @Column(name = "rank", nullable = true, length = 30)
    private String rank;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private List<EducationDocument> educationDocuments;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private List<Award> awards;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_type_id")
    private EmployeeType employeeType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "degree_id")
    private Degree degree;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EmployeeJob> employeeJobs;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher")
    private List<Lesson> lessons;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_department",
            inverseJoinColumns = @JoinColumn(name = "department_id"),
            joinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Department> departments;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "employee_discipline",
            inverseJoinColumns = @JoinColumn(name = "discipline_id"),
            joinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Discipline> disciplines;
}
