package com.luanmateus.springessentials.service;

import com.luanmateus.springessentials.controller.StudentController;
import com.luanmateus.springessentials.model.Student;
import com.luanmateus.springessentials.repository.StudentRepository;
import com.luanmateus.springessentials.util.StudentFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SpringBootTest
@DisplayName("#StudentService")
public class StudentServiceTest {
    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentServiceMock;

    @BeforeEach
    void setUp() {
        Student studentMock = StudentFactory.createValidStudent();

        BDDMockito.when(studentServiceMock.findById(ArgumentMatchers.any()))
                .thenReturn(studentMock);
    }

    @Test
    @DisplayName("Should returns a list of students inside in a page object")
    public void find_ReturnsListOfStudentInsidePageObject() {
        PageImpl<Student> studentPageMock = new PageImpl<>(List.of(StudentFactory.createValidStudent()));

        BDDMockito.when(studentServiceMock.findAll(ArgumentMatchers.any()))
                .thenReturn(studentPageMock);

        String expectedName = StudentFactory.createValidStudent().getName();

        var studentPageResponse = studentController
                .findAll(null, null);

        List<Student> studentList = (Objects.requireNonNull(studentPageResponse.getBody()).toList());

        Assertions.assertThat(studentList)
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(studentList.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("Should returns a Student by id")
    public void findById_ReturnsStudentById() {
        var student = studentController.findById(1L);
    }
}