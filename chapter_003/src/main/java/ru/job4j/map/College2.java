package ru.job4j.map;

import ru.job4j.map.Student;
import ru.job4j.map.Subject;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College2 {
    private final Map<Student, Set<Subject>> student;

    public College2(Map<Student, Set<Subject>> students) {
        this.student = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s : student.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            Set<Subject> subjects = student.get(s.get());
            for (Subject subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}
