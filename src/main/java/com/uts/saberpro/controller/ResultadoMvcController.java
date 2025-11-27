package com.uts.saberpro.controller;

import com.uts.saberpro.model.Resultado;
import com.uts.saberpro.repository.ResultadoRepository;
import com.uts.saberpro.repository.EstudianteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
//@RequestMapping("/resultados")
public class ResultadoMvcController {

    private final ResultadoRepository resultadoRepository;
    private final EstudianteRepository estudianteRepository;

    public ResultadoMvcController(ResultadoRepository resultadoRepository,
                                  EstudianteRepository estudianteRepository) {
        this.resultadoRepository = resultadoRepository;
        this.estudianteRepository = estudianteRepository;
    }

    // GET /resultados → lista de resultados
    @GetMapping
    public String listarResultados(Model model) {
        model.addAttribute("resultados", resultadoRepository.findAll());
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        return "resultados"; // templates/resultados.html
    }

    // GET /resultados/nuevo → formulario
    @GetMapping("/nuevo")
    public String nuevoResultado(Model model) {
        model.addAttribute("resultado", new Resultado());
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        return "resultado-form"; // si no existe, luego lo ajustamos
    }

    // POST /resultados → guardar
    @PostMapping
    public String guardarResultado(@ModelAttribute Resultado resultado) {
        resultadoRepository.save(resultado);
        return "redirect:/resultados";
    }
}
