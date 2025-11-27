package com.uts.saberpro.controller;

import com.uts.saberpro.repository.ResultadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    private final ResultadoRepository resultadoRepository;

    public ReporteController(ResultadoRepository resultadoRepository) {
        this.resultadoRepository = resultadoRepository;
    }

    @GetMapping
    public String verReportes(Model model) {
        Double promedioGlobal = resultadoRepository.calcularPromedioGlobal();
        model.addAttribute("promedioGlobal", promedioGlobal != null ? promedioGlobal : 0);
        model.addAttribute("promedioPorPrograma", resultadoRepository.promedioPorPrograma());
        model.addAttribute("topResultados", resultadoRepository.findTop5ByOrderByPuntajeGlobalDesc());
        return "reportes";
    }
}
