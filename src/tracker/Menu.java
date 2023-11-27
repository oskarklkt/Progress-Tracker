package tracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        if (command.trim().isEmpty()) {
            System.out.println("No input.");
            start();
        } else if (command.equals("exit")) {
            System.out.println("Bye!");
            System.exit(0);
        } else if (command.equals("back")) {
            System.out.println("Enter 'exit' to exit the program.");
            start();
        } else if (command.equals("add students")) {
            System.out.println("Enter student credentials or 'back' to return:");
            addStudent(0);
        } else if (command.equals("list")) {
            if (Student.getStudentList().isEmpty()) {
                System.out.println("No students found");
            } else {
                System.out.println("Students:");
                Student.listAllStudents();
            }
        } else if (command.equals("add points")) {
            System.out.println("Enter an id and points or 'back' to return");
        } else {
            System.out.println("Unknown command!");
            start();
        }
    }

    public static void addStudent(int studentsAdded) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[] commandArray = command.split(" ");
        if (commandArray.length >= 3) {
            String firstname = commandArray[0];
            String email = commandArray[commandArray.length - 1];
            StringBuilder lastName = new StringBuilder(commandArray[1]);
            for (int i = 2; i < commandArray.length - 1; i++) {
                lastName.append(" ");
                lastName.append(commandArray[i]);
            }
            RegexChecker regexChecker = new RegexChecker();
            if (!regexChecker.checkFirstName(firstname)) {
                System.out.println("Incorrect first name.\n");
                addStudent(studentsAdded);
            }
            else if (!regexChecker.checkLastName(String.valueOf(lastName))) {
                System.out.println("Incorrect last name.\n");
                addStudent(studentsAdded);
            }
            else if (!regexChecker.checkEmail(email)) {
                System.out.println("Incorrect email.\n");
                addStudent(studentsAdded);
            } else if (Student.getUsedEmails().containsValue(email)) {
                System.out.println("This email is already taken.");
                addStudent(studentsAdded);
            } else {
                System.out.println("The student has been added.");
                Student student = new Student(firstname, lastName.toString(), email);
                studentsAdded++;
                addStudent(studentsAdded);
            }
        } else if (commandArray[0].equals("back")) {
            System.out.printf("Total %d students have been added.\n", studentsAdded);
            start();
        } else {
            System.out.println("Incorrect credentials.");
            addStudent(studentsAdded);
        }
    }

    public static void addPoints() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("back")) {
            start();
        }
        RegexChecker regexChecker = new RegexChecker();
        if (regexChecker.checkAddPointsInput(input)) {
            String[] arr = input.split(" ");
            ArrayList<Integer> list = new ArrayList<>();
            for (String string : arr) {
                list.add(Integer.parseInt(string));
            }


            int id = list.get(0);
            int javaScore = list.get(1);
            int dsaScore = list.get(2);
            int databasesScore = list.get(3);
            int springScore = list.get(4);

            JavaCourse.setGradeById(id, javaScore);
            DSACourse.setGradeById(id, dsaScore);
            DatabasesCourse.setGradeById(id, databasesScore);
            SpringCourse.setGradeById(id, springScore);

            System.out.println("Points updated");
        }
    }


}
