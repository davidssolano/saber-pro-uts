package com.uts.saberpro.controller;

import com.uts.saberpro.model.Estudiante;
import com.uts.saberpro.repository.EstudianteRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteRepository estudianteRepository;

    public EstudianteController(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        return "estudiantes";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("titulo", "Registrar estudiante");
        return "estudiante-form";
    }

    @PostMapping
    public String guardar(@Valid Estudiante estudiante, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Registrar estudiante");
            return "estudiante-form";
        }
        estudianteRepository.save(estudiante);
        redirectAttributes.addFlashAttribute("mensaje", "Estudiante guardado correctamente");
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return estudianteRepository.findById(id)
                .map(estudiante -> {
                    model.addAttribute("estudiante", estudiante);
                    model.addAttribute("titulo", "Editar estudiante");
                    return "estudiante-form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("error", "Estudiante no encontrado");
                    return "redirect:/estudiantes";
                });
    }

    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @Valid Estudiante estudiante, BindingResult result,
                             RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Editar estudiante");
            return "estudiante-form";
        }

        return estudianteRepository.findById(id)
                .map(existente -> {
                    estudiante.setId(existente.getId());
                    estudianteRepository.save(estudiante);
                    redirectAttributes.addFlashAttribute("mensaje", "Estudiante actualizado");
                    return "redirect:/estudiantes";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("error", "Estudiante no encontrado");
                    return "redirect:/estudiantes";
                });
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Estudiante eliminado");
        } else {
            redirectAttributes.addFlashAttribute("error", "No se encontró el estudiante");
        }
        return "redirect:/estudiantes";
    }
}
