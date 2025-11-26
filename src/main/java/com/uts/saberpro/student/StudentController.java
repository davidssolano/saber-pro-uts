package com.uts.saberpro.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Student> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student) {
        return repository.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student updated) {
        Student existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

        existing.setCode(updated.getCode());
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setProgram(updated.getProgram());
        existing.setGlobalScore(updated.getGlobalScore());

        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
