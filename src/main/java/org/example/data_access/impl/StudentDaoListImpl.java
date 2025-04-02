package org.example.data_access.impl;

import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoListImpl implements StudentDao {
    List<Student> students;

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public void delete(int id) {

    }
}
