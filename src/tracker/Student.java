package tracker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Student {
    private static int nextId = 1;
    private static HashMap<Integer, String> usedEmails = new HashMap<>();
    private static ArrayList<Student> studentList = new ArrayList<>();
    private final int studentId;
    private final String firstName;
    private final String lastName;
    private final String email;

    public Student(String firstName, String lastName, String email) {
        this.studentId = nextId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        studentList.add(this);
        usedEmails.put(studentId, email);
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public static HashMap<Integer, String> getUsedEmails() {
        return usedEmails;
    }

    public static ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void printId() {
        System.out.println(studentId);
    }


    public static void listAllStudents() {
        studentList.stream()
                .sorted(Comparator.comparing(Student::getStudentId))
                .forEach(Student::printId);
    }
}