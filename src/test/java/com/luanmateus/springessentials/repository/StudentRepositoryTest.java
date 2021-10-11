package com.luanmateus.springessentials.repository;

import com.luanmateus.springessentials.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@DisplayName("#StudentRepository")
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @DisplayName("Should persist an student in database")
    void savePersistStudentWhenSuccessful() {
        Student studentToBeSaved = studentFactory();

        Student studentSaved = this.studentRepository.save(studentToBeSaved);

        Assertions.assertThat(studentSaved).isNotNull();
        Assertions.assertThat(studentSaved.getId()).isNotNull();
        Assertions.assertThat(studentSaved.getName()).isEqualTo(studentToBeSaved.getName());
        Assertions.assertThat(studentSaved.getEmail()).isEqualTo(studentToBeSaved.getEmail());
    }

    private Student studentFactory() {
        return new Student("John", "john@mail.com");
    }
}
