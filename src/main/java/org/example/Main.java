package org.example;

import org.example.config.AppConfig;
import org.example.data_access.StudentDao;
import org.example.service.impl.StudentManagementConsoleImpl;
import org.example.util.UserInputService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);
        StudentManagementConsoleImpl studentManagementConsole = new StudentManagementConsoleImpl(userInputService, studentDao);
        
        studentManagementConsole.run();
    }
}