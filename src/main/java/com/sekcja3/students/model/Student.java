package com.sekcja3.students.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "seqIdGen", initialValue = 200000, allocationSize = 1)
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seqIdGen")
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String firstName;

    @NotEmpty(message = "last name can't be empty")
    private String lastName;

    @NotBlank
    @Email
    @Column(unique = true) // validacja uniklanosci maila
    private String email;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    public enum Status{
        ACTIVE,
        INACTIVE
    }






}
