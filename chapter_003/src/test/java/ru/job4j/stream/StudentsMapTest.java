package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StudentsMapTest {
    @Test
    public void whenCollectToMap() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(5, "Smith");
        Student student2 = new Student(5, "Depp");
        Student student3 = new Student(4, "Jolie");
        Student student4 = new Student(5, "Smith");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        StudentsMap studentsMap = new StudentsMap();

        Map<String, Student> mapOfStudents = studentsMap.collectToMap(students);
        Map<String, Student> expected =  new HashMap<>();
        expected.put("Smith", student1);
        expected.put("Depp", student2);
        expected.put("Jolie", student3);

        assertThat(mapOfStudents, is(expected));

    }

}