package com.tanoh.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne()
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToOne()
    @JoinColumn()
    private Teacher teacher;

}
