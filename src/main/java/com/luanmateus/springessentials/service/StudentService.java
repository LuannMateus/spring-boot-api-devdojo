package com.luanmateus.springessentials.service;

import com.luanmateus.springessentials.model.Student;
import com.luanmateus.springessentials.repository.StudentRepository;
import com.luanmateus.springessentials.util.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student findById(Long id) throws ResourceNotFoundException {
        verifyIfExists(id);

        return studentRepository.findById(id).orElseThrow(() -> new Error("Student does not exist"));
    }

    public List<Student> findByName(String name) {
        return studentRepository.findByNameIgnoreCaseContaining(name);
    }

    @Transactional
    public Student save(Student student) {

        return studentRepository.save(student);
    }

    public Student update(Long id, Student student) throws ResourceNotFoundException {
        verifyIfExists(id);

        student.setId(id);

        return studentRepository.save(student);
    }

    public void deleteById(Long id) throws ResourceNotFoundException {
        verifyIfExists(id);

        studentRepository.deleteById(id);
    }

    private void verifyIfExists(Long id) {
        studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student not found for ID " + id));
    }
}
