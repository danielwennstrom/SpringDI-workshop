package org.example.service.impl;

import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.example.service.StudentManagement;
import org.example.util.UserInputService;

import java.util.List;

public class StudentManagementConsoleImpl implements StudentManagement {
    UserInputService scannerService;
    StudentDao studentDao;
    
    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDao) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }
    
    @Override
    public Student create() {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public Student remove(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public Student edit(Student student) {
        return null;
    }
}
