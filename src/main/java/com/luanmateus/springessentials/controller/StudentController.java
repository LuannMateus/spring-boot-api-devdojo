package com.luanmateus.springessentials.controller;

import com.luanmateus.springessentials.model.Student;
import com.luanmateus.springessentials.service.StudentService;
import com.luanmateus.springessentials.util.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() {
        final List<Student> students = studentService.findAll();

        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

        final Student student = studentService.findById(id);

        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/students/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable(value = "name") String name) {
        final List<Student> students = studentService.findByName(name);

        return ResponseEntity.ok().body(students);
    }

    @PostMapping("/students")
    public ResponseEntity<?> save(@RequestBody Student student) {
        final Student studentSaved = studentService.save(student);

        return ResponseEntity.status(201).body(studentSaved);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Student student)
            throws ResourceNotFoundException {

        final Student studentUpdated = studentService.update(id, student);

        return ResponseEntity.ok().body(studentUpdated);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        studentService.deleteById(id);

        return ResponseEntity.status(200).body("Student with id " + id + " has removed");
    }
}
