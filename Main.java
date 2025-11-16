package org.example;

import org.example.database.DatabaseConnection;
import org.example.ui.MainMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Fashion E-Retail System...");
        
        // Initialize database
        DatabaseConnection.initializeDatabase();
        
        System.out.println("Database initialized successfully!");
        System.out.println("Starting application...\n");
        // Launch the main menu
        MainMenu mainMenu = new MainMenu();
        mainMenu.display();
        
        // Close database connection on exit
        DatabaseConnection.closeConnection();
        System.out.println("\nThank you for using Fashion E-Retail System!");
    }
}