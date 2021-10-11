package com.luanmateus.springessentials.util;

import com.luanmateus.springessentials.model.Student;

public class StudentFactory {
    public static Student createStudentToBeSaved() {
        return new Student("John Doe", "john@mail.com");
    }

    public static Student createValidStudent() {
        return new Student("John Wick", "john@mail.com");
    }

    public static Student createValidUpdateStudentToBeSaved() {
        return new Student("John Doe Change", "john@mail.com");
    }

    public static Student createInvalidStudent() {
        return new Student();
    }
}
