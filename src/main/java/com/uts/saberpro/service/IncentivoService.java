package com.uts.saberpro.service;

import com.uts.saberpro.model.Incentivo;
import com.uts.saberpro.model.Resultado;
import com.uts.saberpro.repository.IncentivoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class IncentivoService {

    private final IncentivoRepository incentivoRepository;

    public IncentivoService(IncentivoRepository incentivoRepository) {
        this.incentivoRepository = incentivoRepository;
    }

    public List<Incentivo> obtenerIncentivosAplicables(Resultado resultado) {
        if (resultado == null || resultado.getPuntajeGlobal() == null) {
            return Collections.emptyList();
        }
        LocalDate fecha = resultado.getFechaPresentacion() != null ? resultado.getFechaPresentacion() : LocalDate.now();
        String programa = resultado.getEstudiante() != null ? resultado.getEstudiante().getPrograma() : null;
        return incentivoRepository.findAplicables(programa, resultado.getPuntajeGlobal(), fecha);
    }
}
