package com.uts.saberpro.controller;

import com.uts.saberpro.model.Incentivo;
import com.uts.saberpro.model.Resultado;
import com.uts.saberpro.repository.EstudianteRepository;
import com.uts.saberpro.repository.ResultadoRepository;
import com.uts.saberpro.service.IncentivoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/resultados")
public class ResultadoController {

    private final ResultadoRepository resultadoRepository;
    private final EstudianteRepository estudianteRepository;
    private final IncentivoService incentivoService;

    public ResultadoController(ResultadoRepository resultadoRepository, EstudianteRepository estudianteRepository,
                               IncentivoService incentivoService) {
        this.resultadoRepository = resultadoRepository;
        this.estudianteRepository = estudianteRepository;
        this.incentivoService = incentivoService;
    }

    @GetMapping
    public String listar(Model model) {
        var resultados = resultadoRepository.findAll();
        Map<Long, List<Incentivo>> incentivosPorResultado = resultados.stream()
                .collect(Collectors.toMap(Resultado::getId, r -> incentivoService.obtenerIncentivosAplicables(r)));
        model.addAttribute("resultados", resultados);
        model.addAttribute("incentivosPorResultado", incentivosPorResultado);
        return "resultados";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("resultado", new Resultado());
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        model.addAttribute("titulo", "Registrar resultado");
        return "resultado-form";
    }

    @PostMapping
    public String guardar(@Valid Resultado resultado, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("estudiantes", estudianteRepository.findAll());
            model.addAttribute("titulo", "Registrar resultado");
            return "resultado-form";
        }
        resultadoRepository.save(resultado);
        redirectAttributes.addFlashAttribute("mensaje", "Resultado guardado correctamente");
        return "redirect:/resultados";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return resultadoRepository.findById(id)
                .map(res -> {
                    model.addAttribute("resultado", res);
                    model.addAttribute("estudiantes", estudianteRepository.findAll());
                    model.addAttribute("titulo", "Editar resultado");
                    return "resultado-form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("error", "Resultado no encontrado");
                    return "redirect:/resultados";
                });
    }

    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @Valid Resultado resultado, BindingResult result,
                             Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("estudiantes", estudianteRepository.findAll());
            model.addAttribute("titulo", "Editar resultado");
            return "resultado-form";
        }

        return resultadoRepository.findById(id)
                .map(existente -> {
                    resultado.setId(existente.getId());
                    resultadoRepository.save(resultado);
                    redirectAttributes.addFlashAttribute("mensaje", "Resultado actualizado");
                    return "redirect:/resultados";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("error", "Resultado no encontrado");
                    return "redirect:/resultados";
                });
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (resultadoRepository.existsById(id)) {
            resultadoRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Resultado eliminado");
        } else {
            redirectAttributes.addFlashAttribute("error", "No se encontró el resultado");
        }
        return "redirect:/resultados";
    }
}
