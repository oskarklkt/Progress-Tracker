package tracker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByKey;

public class DatabasesCourse extends Course {

    private String name = "Databases";

    private int pointsScored;

    private int tasksDone;

    int MAX_POINTS = 480;
    private HashMap<Integer, Integer> studentsGradesMap;

    private static DatabasesCourse instance;

    private DatabasesCourse() {
        this.studentsGradesMap = new HashMap<>();
        tasksDone = 0;
        this.alreadyNotified = new ArrayList<>();
        pointsScored = 0;
    }

    public static DatabasesCourse getInstance() {
        if (instance == null) {
            instance = new DatabasesCourse();
        }
        return instance;
    }

    @Override
    public int getGradeById(int id) {
        return studentsGradesMap.get(id);
    }

    @Override
    public void setGradeById(int id, int grade) {
        studentsGradesMap.put(id, grade);
    }

    public HashMap<Integer, Integer> getStudentsGradesMap() {
        return studentsGradesMap;
    }

    @Override
    public int getEnrolledStudents() {
        return getStudentsGradesMap().size();
    }

    @Override
    public void incrementTaskDone() {
        this.tasksDone++;
    }

    @Override
    public int getTaskDone() {
        return tasksDone;
    }

    public int getPointsScored() {
        return pointsScored;
    }

    @Override
    public void incrementPointsScored(int score) {
        this.pointsScored += score;
    }
    private ArrayList<Integer> alreadyNotified;

    @Override
    public double getAverageGrade() {
        return (double) pointsScored/tasksDone;
    }

    public String getName() {
        return name;
    }

    @Override
    public void printBestStudents() {
        Stream<Map.Entry<Integer, Integer>> sorted = studentsGradesMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed().thenComparing(comparingByKey()))
                .filter((e) -> e.getValue() != 0);
        sorted.forEach(this::printEntry);
    }

    public void printEntry(Map.Entry<Integer, Integer> entry) {
        System.out.printf("%d\t%d\t\t%.1f", entry.getKey(), entry.getValue(), new BigDecimal((double) entry.getValue()/MAX_POINTS).setScale(3, RoundingMode.HALF_UP).scaleByPowerOfTen(2));
        System.out.println("%");
    }

    public ArrayList<Integer> getIdsOfStudentsToNotify() {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer id : getStudentsGradesMap().keySet()) {
            if (getStudentsGradesMap().get(id) == MAX_POINTS && !alreadyNotified.contains(id)) {
                result.add(id);
                alreadyNotified.add(id);
            }

        }
        return result;
    }
}