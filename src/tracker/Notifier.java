package tracker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Notifier {

    public static JavaCourse javaCourse = JavaCourse.getInstance();
    public static SpringCourse springCourse = SpringCourse.getInstance();
    public static DatabasesCourse databasesCourse = DatabasesCourse.getInstance();
    public static DSACourse dsaCourse = DSACourse.getInstance();

    private static Notifier instance;
    public static Notifier getInstance() {
        if (instance == null) {
            instance = new Notifier();
        }
        return instance;
    }

    public void notifyStudents() {
        ArrayList<Integer> studentsToNotify = new ArrayList<>();
        ArrayList<Integer> studentsToNotifyJava = javaCourse.getIdsOfStudentsToNotify();
        ArrayList<Integer> studentsToNotifySpring = springCourse.getIdsOfStudentsToNotify();
        ArrayList<Integer> studentsToNotifyDatabases = databasesCourse.getIdsOfStudentsToNotify();
        ArrayList<Integer> studentsToNotifyDSA = dsaCourse.getIdsOfStudentsToNotify();
        studentsToNotify.addAll(studentsToNotifyJava);
        studentsToNotify.addAll(studentsToNotifyDatabases);
        studentsToNotify.addAll(studentsToNotifyDSA);
        studentsToNotify.addAll(studentsToNotifySpring);

        if (studentsToNotify.isEmpty()) {
            System.out.println("Total 0 students have been notified");
        } else {
            Set<Integer> set = new HashSet<>(studentsToNotify);
            int size = set.size();
            for (Integer id : studentsToNotifyJava) {
                System.out.print("To: ");
                System.out.println(Student.getStudentById(id).getEmail());
                System.out.println("Re: Your Learning Progress");
                System.out.printf("Hello, %s %s! You have accomplished our Java course!\n",    Student.getStudentById(id).getFirstName(),
                                                                                            Student.getStudentById(id).getLastName());
            }
            for (Integer id : studentsToNotifySpring) {
                System.out.print("To: ");
                System.out.println(Student.getStudentById(id).getEmail());
                System.out.println("Re: Your Learning Progress");
                System.out.printf("Hello, %s %s! You have accomplished our Spring course!\n", Student.getStudentById(id).getFirstName(),
                        Student.getStudentById(id).getLastName());
            }
            for (Integer id : studentsToNotifyDatabases) {
                System.out.print("To: ");
                System.out.println(Student.getStudentById(id).getEmail());
                System.out.println("Re: Your Learning Progress");
                System.out.printf("Hello, %s %s! You have accomplished our Databases course!\n", Student.getStudentById(id).getFirstName(),
                        Student.getStudentById(id).getLastName());
            }
            for (Integer id : studentsToNotifyDSA) {
                System.out.print("To: ");
                System.out.println(Student.getStudentById(id).getEmail());
                System.out.println("Re: Your Learning Progress");
                System.out.printf("Hello, %s %s! You have accomplished our DSA course!\n", Student.getStudentById(id).getFirstName(),
                        Student.getStudentById(id).getLastName());
            }

            System.out.printf("Total %d students have been notified.\n", size);
        }

    }
}
