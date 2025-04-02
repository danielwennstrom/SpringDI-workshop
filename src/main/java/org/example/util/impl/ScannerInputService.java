package org.example.util.impl;

import org.example.util.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ScannerInputService implements UserInputService {
    private final Scanner scanner;
    
    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        while (!scanner.hasNextLine()) {
            System.out.println("Please enter a valid integer: ");
            scanner.next();
        }
        
        int input = scanner.nextInt();
        
        if (scanner.hasNextLine())
            scanner.nextLine();
        
        return input;
    }
}
