package com.spring.springconfig.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        //given
        Student student = Student.builder().studentName("Student1")
                .build();

        //when
        studentRepository.save(student);

        //then
        List<Student> allStudents = studentRepository.findAll();

        assertEquals(1, allStudents.size());
        assertEquals(student.getStudentName(), allStudents.get(0).getStudentName());
    }
}
