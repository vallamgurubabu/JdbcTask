//Hospital Management System

package com.java.test;

import java.util.Scanner;
import java.sql.SQLException;

public class index {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		 	//Object Creation for Hospital Patient Management 
		 	HospitalPatientManagement hpm = new HospitalPatientManagement();

		 	//Scanner class for taking dynamic data from user
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	        	// Menu to do Operations on Hospital Patient Management System
	            System.out.println("\n--- Hospital Patient Management System ---");
	            System.out.println("1. Add Patient");
	            System.out.println("2. Update Patient Condition");
	            System.out.println("3. Delete Patient by Patient_ID");
	            System.out.println("4. Delete Patient by Condition");
	            System.out.println("5. Display All Patients");
	            System.out.println("6. Display Patients (Age < 30)");
	            System.out.println("7. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1: // Add Patient
	                    System.out.print("Enter Patient ID: ");
	                    int id = scanner.nextInt();
	                    scanner.nextLine(); 
	                    System.out.print("Enter Patient Name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter Patient Age: ");
	                    int age = scanner.nextInt();
	                    scanner.nextLine(); 
	                    System.out.print("Enter Patient Gender: ");
	                    String gender = scanner.nextLine();
	                    System.out.print("Enter Patient Condition: ");
	                    String condition = scanner.nextLine();
	                    try {
	                        hpm.add(id, name, age, gender, condition);
	                    } catch (ClassNotFoundException | SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;

	                case 2: // Update Patient Condition
	                    System.out.print("Enter Patient ID: ");
	                    int updateId = scanner.nextInt();
	                    scanner.nextLine(); 
	                    System.out.print("Enter New Condition: ");
	                    String newCondition = scanner.nextLine();
	                    try {
	                        hpm.updateConditions(updateId, newCondition);
	                    } catch (ClassNotFoundException | SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;

	                case 3: // Delete Patient by ID
	                    System.out.print("Enter Patient ID: ");
	                    int deleteId = scanner.nextInt();
	                    try {
	                        hpm.deleteById(deleteId);
	                    } catch (ClassNotFoundException | SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;

	                case 4: // Delete Patient by Condition
	                    System.out.print("Enter Condition: ");
	                    scanner.nextLine(); 
	                    String deleteCondition = scanner.nextLine();
	                    try {
	                        hpm.deleteByCondition(deleteCondition);
	                    } catch (ClassNotFoundException | SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;

	                case 5: // Display All Patients
	                    try {
	                        hpm.display();
	                    } catch (ClassNotFoundException | SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;

	                case 6: // Display Patients (Age < 30)
	                    try {
	                        hpm.displayDetailsByAgeLess30Years();
	                    } catch (ClassNotFoundException | SQLException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;

	                case 7: // Exit
	                    System.out.println("Exiting... Thank you for using the Hospital Patient Management System!");
	                    break;

	                default:
	                    System.out.println("Invalid choice! Please try again.");
	            }
	        } while (choice != 7);

	        scanner.close();
		
	}
}
