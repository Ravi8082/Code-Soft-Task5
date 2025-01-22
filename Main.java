package Task5;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    // Add Student
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();

                    if (name.isEmpty() || grade.isEmpty()) {
                        System.out.println("Error: Name and Grade cannot be empty.");
                    } else {
                        sms.addStudent(new Student(name, rollNumber, grade));
                        System.out.println("Student added successfully.");
                    }
                }
                case 2 -> {
                    // Remove Student
                    System.out.print("Enter Roll Number to Remove: ");
                    int rollNumber = scanner.nextInt();
                    if (sms.removeStudent(rollNumber)) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Error: Student not found.");
                    }
                }
                case 3 -> {
                    // Search Student
                    System.out.print("Enter Roll Number to Search: ");
                    int rollNumber = scanner.nextInt();
                    Student student = sms.searchStudent(rollNumber);
                    if (student != null) {
                        System.out.println("Student Found: " + student);
                    } else {
                        System.out.println("Error: Student not found.");
                    }
                }
                case 4 -> {
                    // Display All Students
                    System.out.println("\n--- All Students ---");
                    sms.displayAllStudents();
                }
                case 5 -> {
                    // Exit
                    System.out.println("Exiting Student Management System.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
