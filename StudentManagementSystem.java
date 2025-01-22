package Task5;
import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> students;
    private static final String FILE_NAME = "students.dat";

    // Constructor to initialize the student list
    public StudentManagementSystem() {
        this.students = loadStudentsFromFile();
    }

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
    }

    // Remove a student by roll number
    public boolean removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                saveStudentsToFile();
                return true;
            }
        }
        return false;
    }

    // Search for a student by roll number
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Save students to a file
    private void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.err.println("Error saving students to file: " + e.getMessage());
        }
    }

    // Load students from a file
    private List<Student> loadStudentsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading students from file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
