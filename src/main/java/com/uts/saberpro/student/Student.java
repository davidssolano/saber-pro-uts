package com.uts.saberpro.student;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;          // Código del estudiante

    @Column(nullable = false)
    private String firstName;     // Nombres

    @Column(nullable = false)
    private String lastName;      // Apellidos

    private String program;       // Programa académico

    private Double globalScore;   // Puntaje global Saber Pro

    public Student() {
    }

    public Student(String code, String firstName, String lastName, String program, Double globalScore) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.program = program;
        this.globalScore = globalScore;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    public Double getGlobalScore() { return globalScore; }
    public void setGlobalScore(Double globalScore) { this.globalScore = globalScore; }
}
