package tracker;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private static int id;
    private static HashMap<Integer, String> usedEmails = new HashMap<>();
    private static ArrayList<Student> studentList = new ArrayList<>();
    private final int studentId;
    private final String firstName;
    private final String lastName;
    private final String email;

    public Student(String firstName, String lastName, String email) {
        this.studentId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        studentList.add(new Student(firstName, lastName, email));
        usedEmails.put(studentId, email);
        id++;
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
}
