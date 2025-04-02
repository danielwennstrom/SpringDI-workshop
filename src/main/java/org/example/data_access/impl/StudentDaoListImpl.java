package org.example.data_access.impl;

import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentDaoListImpl implements StudentDao {
    List<Student> students;

    public StudentDaoListImpl(List<Student> students) {
        this.students = students;
    }

    @Override
    public Student save(Student student) {
        if (students.contains(student)) {
            students.remove(student);
        }
        
        students.add(student);
        
        return student;
    }

    @Override
    public Student find(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return students.stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        students.removeIf(s -> s.getId() == id);
    }
}
