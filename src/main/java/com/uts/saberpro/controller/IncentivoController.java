package com.uts.saberpro.controller;

import com.uts.saberpro.model.Incentivo;
import com.uts.saberpro.repository.IncentivoRepository;
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
@RequestMapping("/incentivos")
public class IncentivoController {

    private final IncentivoRepository incentivoRepository;

    public IncentivoController(IncentivoRepository incentivoRepository) {
        this.incentivoRepository = incentivoRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("incentivos", incentivoRepository.findAll());
        return "incentivos";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("incentivo", new Incentivo());
        model.addAttribute("titulo", "Registrar incentivo");
        return "incentivo-form";
    }

    @PostMapping
    public String guardar(@Valid Incentivo incentivo, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", incentivo.getId() == null ? "Registrar incentivo" : "Editar incentivo");
            return "incentivo-form";
        }
        incentivoRepository.save(incentivo);
        redirectAttributes.addFlashAttribute("mensaje", "Incentivo guardado correctamente");
        return "redirect:/incentivos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return incentivoRepository.findById(id)
                .map(incentivo -> {
                    model.addAttribute("incentivo", incentivo);
                    model.addAttribute("titulo", "Editar incentivo");
                    return "incentivo-form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("error", "Incentivo no encontrado");
                    return "redirect:/incentivos";
                });
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (incentivoRepository.existsById(id)) {
            incentivoRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Incentivo eliminado");
        } else {
            redirectAttributes.addFlashAttribute("error", "No se encontró el incentivo");
        }
        return "redirect:/incentivos";
    }
}
