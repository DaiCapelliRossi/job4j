package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsMap {
    public Map<String, Student> collectToMap(List<Student> students) {
        Map<String, Student> mapOfStudents = students.stream()
                .distinct()
                .collect(Collectors.toMap(
                        e -> e.getSurname(),
                        e -> e
                ));
        return mapOfStudents;
    }
}
