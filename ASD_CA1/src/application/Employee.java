package application;

/* 
 * File name : Employee.java
 * Author : Shannon Donnelly
 * Student number : c23302301
 * Description of class : Represents an Employee enrolled in a training course with validation
 */

public class Employee {
    private int employeeNumber;
    private String name;
    private int yearsWorking;
    private String trainingCourse;

    // Parameter Constructor with Validation
    public Employee(int employeeNumber, String name, int yearsWorking, String trainingCourse) {
        this.employeeNumber = employeeNumber;
        this.name = name;

        // Validate yearsWorking
        if (yearsWorking < 5) {
            System.out.println("Error: Employees with less than 5 years experience cannot enroll.");
            this.yearsWorking = 0; // Default value indicating invalid enrollment status
        } else {
            this.yearsWorking = yearsWorking;
        }

        // Validate trainingCourse
        if (trainingCourse != null && !trainingCourse.startsWith("FOOD")) {
            System.out.println("Error: Course name should start with 'FOOD'. Setting course to 'ERROR'.");
            this.trainingCourse = "ERROR";
        } else {
            this.trainingCourse = trainingCourse;
        }
    }

    // Default Constructor (Initializes with Default Values)
    public Employee() {
        this.employeeNumber = 0;
        this.name = "";
        this.yearsWorking = 0;
        this.trainingCourse = "ERROR";
    }

    // Getters and Setters
    public int getEmployeeNumber() { return employeeNumber; }
    public void setEmployeeNumber(int employeeNumber) { this.employeeNumber = employeeNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getYearsWorking() { return yearsWorking; }
    public void setYearsWorking(int yearsWorking) {
        if (yearsWorking >= 5) {
            this.yearsWorking = yearsWorking;
        } else {
            System.out.println("Error: Must have 5+ years of experience.");
            this.yearsWorking = 0; // Invalid input case
        }
    }

    public String getTrainingCourse() { return trainingCourse; }
    public void setTrainingCourse(String trainingCourse) {
        if (trainingCourse != null && trainingCourse.startsWith("FOOD")) {
            this.trainingCourse = trainingCourse;
        } else {
            System.out.println("Error: Course name should start with 'FOOD'. Setting course to 'ERROR'.");
            this.trainingCourse = "ERROR";
        }
    }

    // Method to display employee details in a user-friendly format
    public void displayEmployeeDetails() {
        System.out.println("Employee Number: " + employeeNumber +
                           ", Name: " + name +
                           ", Years Working: " + yearsWorking +
                           ", Training Course: " + trainingCourse);
    }

    // Method to compare two employees by employee number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return employeeNumber == employee.employeeNumber;
    }
}
