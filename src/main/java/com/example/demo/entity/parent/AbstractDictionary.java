package com.example.demo.entity.parent;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class AbstractDictionary  {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
