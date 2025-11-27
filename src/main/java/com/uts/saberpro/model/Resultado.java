package com.uts.saberpro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "resultados")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    @NotNull(message = "La fecha de presentación es obligatoria")
    private LocalDate fechaPresentacion;

    @NotNull
    @Min(value = 0, message = "El puntaje no puede ser negativo")
    @Max(value = 300, message = "El puntaje no debe superar 300")
    private Integer lecturaCritica;

    @NotNull
    @Min(0)
    @Max(300)
    private Integer razonamientoCuantitativo;

    @NotNull
    @Min(0)
    @Max(300)
    private Integer ingles;

    @NotNull
    @Min(0)
    @Max(300)
    private Integer comunicacionEscrita;

    @NotNull
    @Min(0)
    @Max(300)
    private Integer competenciasCiudadanas;

    @NotNull
    @Min(0)
    @Max(300)
    private Integer formulacionProyectos;

    @NotNull
    @Min(0)
    @Max(300)
    @Column(name = "puntaje_global")
    private Integer puntajeGlobal;

    public Resultado() {
    }

    public Resultado(Estudiante estudiante, LocalDate fechaPresentacion, Integer lecturaCritica, Integer razonamientoCuantitativo,
                     Integer ingles, Integer comunicacionEscrita, Integer competenciasCiudadanas, Integer formulacionProyectos,
                     Integer puntajeGlobal) {
        this.estudiante = estudiante;
        this.fechaPresentacion = fechaPresentacion;
        this.lecturaCritica = lecturaCritica;
        this.razonamientoCuantitativo = razonamientoCuantitativo;
        this.ingles = ingles;
        this.comunicacionEscrita = comunicacionEscrita;
        this.competenciasCiudadanas = competenciasCiudadanas;
        this.formulacionProyectos = formulacionProyectos;
        this.puntajeGlobal = puntajeGlobal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(LocalDate fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public Integer getLecturaCritica() {
        return lecturaCritica;
    }

    public void setLecturaCritica(Integer lecturaCritica) {
        this.lecturaCritica = lecturaCritica;
    }

    public Integer getRazonamientoCuantitativo() {
        return razonamientoCuantitativo;
    }

    public void setRazonamientoCuantitativo(Integer razonamientoCuantitativo) {
        this.razonamientoCuantitativo = razonamientoCuantitativo;
    }

    public Integer getIngles() {
        return ingles;
    }

    public void setIngles(Integer ingles) {
        this.ingles = ingles;
    }

    public Integer getComunicacionEscrita() {
        return comunicacionEscrita;
    }

    public void setComunicacionEscrita(Integer comunicacionEscrita) {
        this.comunicacionEscrita = comunicacionEscrita;
    }

    public Integer getCompetenciasCiudadanas() {
        return competenciasCiudadanas;
    }

    public void setCompetenciasCiudadanas(Integer competenciasCiudadanas) {
        this.competenciasCiudadanas = competenciasCiudadanas;
    }

    public Integer getFormulacionProyectos() {
        return formulacionProyectos;
    }

    public void setFormulacionProyectos(Integer formulacionProyectos) {
        this.formulacionProyectos = formulacionProyectos;
    }

    public Integer getPuntajeGlobal() {
        return puntajeGlobal;
    }

    public void setPuntajeGlobal(Integer puntajeGlobal) {
        this.puntajeGlobal = puntajeGlobal;
    }
}
