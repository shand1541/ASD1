package application;

import util.LinkedList;
import java.util.Scanner;

/* 
 * File name : TrainingCourses.java
 * Author : Shannon Donnelly 
 * Student number : c23302301
 * Description of class : Driver class for managing employee training course enrollments
 */

public class TrainingCourses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Employee> employeeList = new LinkedList<Employee>();

        // 1. Allow user to input up to 10 employees
        System.out.print("Enter the number of employees (up to 10): ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (numEmployees < 1 || numEmployees > 10) {
            System.out.println("Error: Number of employees must be between 1 and 10.");
            return;
        }

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");

            System.out.print("Employee Number: ");
            int employeeNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Years Working: ");
            int yearsWorking = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Training Course Name: ");
            String courseName = scanner.nextLine();

            Employee employee = new Employee(employeeNumber, name, yearsWorking, courseName);
            if (!employeeList.contains(employee)) {
                employeeList.add(employee);
            } else {
                System.out.println("Error: Employee with this number already exists.");
            }
        }

        // 2. Display all employee details
        System.out.println("\nDisplaying all employees:");
        employeeList.displayList();

        // 3. Remove an employee from a training course by employee number
        System.out.print("\nEnter employee number to remove from the course: ");
        int removeEmployeeNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee employeeToRemove = findEmployeeByNumber(employeeList, removeEmployeeNumber);
        if (employeeToRemove != null) {
            employeeList.delete(employeeToRemove);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Error: Employee not found.");
        }

        // 4. Display the list again after removal
        System.out.println("\nDisplaying updated list of employees:");
        employeeList.displayList();
    }

    // Utility method to find an employee by number
    public static Employee findEmployeeByNumber(LinkedList<Employee> list, int employeeNumber) {
        LinearNode<Employee> current = list.getFirst();
        while (current != null) {
            if (current.getElement().getEmployeeNumber() == employeeNumber) {
                return current.getElement();
            }
            current = current.getNext();
        }
        return null;
    }
}

