package com.example.demo.entity;

import com.example.demo.entity.parent.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "award")
public class Award extends AbstractEntity {
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
