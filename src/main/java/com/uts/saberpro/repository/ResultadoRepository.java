package com.uts.saberpro.repository;

import com.uts.saberpro.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultadoRepository extends JpaRepository<Resultado, Long> {

    interface PromedioPrograma {
        String getPrograma();
        Double getPromedio();
    }

    @Query("SELECT AVG(r.puntajeGlobal) FROM Resultado r")
    Double calcularPromedioGlobal();

    @Query("SELECT r.estudiante.programa AS programa, AVG(r.puntajeGlobal) AS promedio " +
            "FROM Resultado r GROUP BY r.estudiante.programa ORDER BY promedio DESC")
    List<PromedioPrograma> promedioPorPrograma();

    List<Resultado> findTop5ByOrderByPuntajeGlobalDesc();

    @Query("SELECT r FROM Resultado r WHERE r.estudiante.id = :estudianteId")
    List<Resultado> findByEstudiante(@Param("estudianteId") Long estudianteId);
}
