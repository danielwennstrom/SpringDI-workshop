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
        return "";
    }

    @Override
    public int getInt() {
        return 0;
    }
}
