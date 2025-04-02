package org.example.service.impl;

import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.example.sequencer.StudentSequencer;
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
    
    public void run() {
        while (true) {
            System.out.println("Welcome to the Student Management Console");
            System.out.println("1. Create Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Find Student");
            System.out.println("4. Remove Student");
            System.out.println("5. List All Students");
            System.out.println("6. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scannerService.getInt();
            
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    System.out.println("Enter student ID: ");
                    Student student = find(scannerService.getInt());
                    save(edit(student));
                    break;
                case 3:
                    System.out.println("Enter student ID: ");
                    find(scannerService.getInt());
                    break;
                case 4:
                    System.out.println("Enter student ID: ");
                    remove(scannerService.getInt());
                    break;
                case 5:
                    listAll();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listAll() {
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public Student create() {
        System.out.println("Enter student name: ");
        String name = scannerService.getString();
        Student student = new Student(name, StudentSequencer.getNextId());

        return save(student);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        Student student = studentDao.find(id);
        if (student == null) {
            System.out.println("Student not found.");
            return null;
        }
        
        return student;
    }

    @Override
    public Student remove(int id) {
        Student student = studentDao.find(id);
        System.out.printf("Do you want to delete student (%s) %s? Y/N \n", student.getId(), student.getId());
        if (scannerService.getString().equalsIgnoreCase("Y")) {
            System.out.println("Deleting student.");
            studentDao.delete(id);
        } else {
            System.out.println("Student not deleted.");
            return null;
        }
        
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        System.out.println("Enter new student name: ");
        String newName = scannerService.getString();
        student.setName(newName);
        
        return studentDao.save(student);
    }
}
