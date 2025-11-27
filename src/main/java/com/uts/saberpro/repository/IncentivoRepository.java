package com.uts.saberpro.repository;

import com.uts.saberpro.model.Incentivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IncentivoRepository extends JpaRepository<Incentivo, Long> {

    @Query("SELECT i FROM Incentivo i WHERE i.activo = true " +
            "AND (:programa IS NULL OR i.programaObjetivo IS NULL OR LOWER(i.programaObjetivo) = LOWER(:programa)) " +
            "AND :puntaje BETWEEN i.puntajeMinimo AND i.puntajeMaximo " +
            "AND :fecha BETWEEN i.vigenciaInicio AND i.vigenciaFin")
    List<Incentivo> findAplicables(@Param("programa") String programa,
                                   @Param("puntaje") double puntaje,
                                   @Param("fecha") LocalDate fecha);
}
