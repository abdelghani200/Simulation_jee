package com.jee_simulation.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
public abstract class Person  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(length = 255, nullable = false)
    protected String firstName;

    @Column(length = 255, nullable = false)
    protected String lastName;

    @Column(columnDefinition = "DATE", nullable = false)
    protected LocalDate birthDate;

    @Column(length = 15, nullable = false, unique = true)
    protected String phoneNumber;
    
}
