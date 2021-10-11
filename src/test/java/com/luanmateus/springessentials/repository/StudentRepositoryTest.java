package com.luanmateus.springessentials.repository;

import com.luanmateus.springessentials.model.Student;
import com.luanmateus.springessentials.util.StudentFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

@SpringBootTest
@DisplayName("#StudentRepository")
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @DisplayName("Should persist an student in database")
    public void savePersistStudentWhenSuccessful() {
        Student studentToBeSaved = StudentFactory.createStudentToBeSaved();

        Student studentSaved = this.studentRepository.save(studentToBeSaved);

        Assertions.assertThat(studentSaved).isNotNull();
        Assertions.assertThat(studentSaved.getId()).isNotNull();
        Assertions.assertThat(studentSaved.getName()).isEqualTo(studentToBeSaved.getName());
        Assertions.assertThat(studentSaved.getEmail()).isEqualTo(studentToBeSaved.getEmail());
    }

    @Test
    @DisplayName("Should throw ConstraintViolationException when student name is empty")
    public void saveThrowsConstraintViolationExceptionWhenStudentNameIsEmpty() {
        Student studentToBeSaved = StudentFactory.createInvalidStudent();

        Assertions.assertThatExceptionOfType(TransactionSystemException.class)
                .isThrownBy(() -> studentRepository.save(studentToBeSaved));
    }
}
