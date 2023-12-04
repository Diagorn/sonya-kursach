package com.example.demo.entity;

import com.example.demo.entity.parent.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lesson")
public class Lesson extends AbstractEntity {
    @Column(name = "date_start", nullable = true)
    private LocalDateTime dateStart;
    @Column(name = "date_end", nullable = true)
    private LocalDateTime dateEnd;
    @Column(name = "room", nullable = true, length = 10)
    private String room;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee teacher;
}
