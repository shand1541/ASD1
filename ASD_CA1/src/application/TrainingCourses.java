package application;

import util.LinkedList;
import java.util.Scanner;

/* 
 * File name : TrainingCourses.java
 * Author : shannon donnelly 
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
            employeeList.add(employee);
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
            System.out.println("Employee not found.");
        }

        // 4. Display details of all employees on training courses
        System.out.println("\nDisplaying all employees still on courses:");
        employeeList.displayList();

        // 5. Delete all employees enrolled in a specified course
        System.out.print("\nEnter the name of the course to delete all enrollments: ");
        String courseToDelete = scanner.nextLine();
        deleteEmployeesByCourse(employeeList, courseToDelete);

        // 6. Display the remaining employees
        System.out.println("\nDisplaying remaining employees:");
        employeeList.displayList();

        // 7. Run a custom function (e.g., count employees with over 10 years experience)
        int experiencedEmployees = countExperiencedEmployees(employeeList, 10);
        System.out.println("\nNumber of employees with over 10 years of experience: " + experiencedEmployees);

        scanner.close();
    }

    // Custom function to count employees with a certain level of experience
    private static int countExperiencedEmployees(LinkedList<Employee> employeeList, int years) {
        int count = 0;
        Employee current = employeeList.getFirst();
        while (current != null) {
            if (current.getYearsWorking() > years) {
                count++;
            }
            current = employeeList.getNext(current);
        }
        return count;
    }

    // Helper method to find an employee by their number
    private static Employee findEmployeeByNumber(LinkedList<Employee> employeeList, int employeeNumber) {
        Employee current = employeeList.getFirst();
        while (current != null) {
            if (current.getEmployeeNumber() == employeeNumber) {
                return current;
            }
            current = employeeList.getNext(current);
        }
        return null;
    }

    // Helper method to delete all employees enrolled in a specific course
    private static void deleteEmployeesByCourse(LinkedList<Employee> employeeList, String courseName) {
        Employee current = employeeList.getFirst();
        while (current != null) {
            Employee nextEmployee = employeeList.getNext(current);
            if (current.getTrainingCourse().equals(courseName)) {
                employeeList.delete(current);
            }
            current = nextEmployee;
        }
        System.out.println("Deleted all employees enrolled in course: " + courseName);
    }
}
