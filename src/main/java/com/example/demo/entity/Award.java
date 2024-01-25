package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "award")
public class Award {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "award_seq")
    @SequenceGenerator(name = "award_seq", sequenceName = "award_seq", allocationSize = 1)
    private Long id;
    @Column(name = "text", nullable = false, length = 2000)
    private String text;
    @Column(name = "date_recieve")
    private LocalDate dateRecieve;
    @Column(name = "giver_organization", nullable = false, length = 512)
    private String giverOrganization;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
