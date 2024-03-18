import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int rollNumber;
    private String studentName;
    private String fatherName;
    private String grade;

    public Student(int rollNumber, String studentName, String fatherName, String grade) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getGrade() {
        return grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(String name) {
        for (Student student : students) {
            if (student.getStudentName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println();
            System.out.println("Roll Number : " + student.getRollNumber()  + "\t Student Name : "  + student.getStudentName() + "\t Father's Name : " + student.getFatherName() + "\t Grade : " + student.getGrade());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem managementSystem = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Father's Name: ");
                    String fatherName = scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    managementSystem.addStudent(new Student(rollNumber, studentName, fatherName, grade));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Roll Number of the Student to Remove: ");
                    int rollToRemove = scanner.nextInt();
                    managementSystem.removeStudent(rollToRemove);
                    System.out.println("Student removed successfully!");
                    break;
                case 3:
                    System.out.print("Enter Student name to Search: ");
                    String nameToSearch = scanner.nextLine();
                    Student searchedStudent = managementSystem.searchStudent(nameToSearch);
                    if (searchedStudent != null) {
                        System.out.println("Student Found:");
                        System.out.println("Roll Number: " + searchedStudent.getRollNumber());
                        System.out.println("Student Name: " + searchedStudent.getStudentName());
                        System.out.println("Father's Name: " + searchedStudent.getFatherName());
                        System.out.println("Grade: " + searchedStudent.getGrade());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 4:
                    managementSystem.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
