package tracker;

import java.util.HashMap;

public class JavaCourse extends Course {

    private int pointsScored;

    private int tasksDone;

    int MAX_POINTS = 600;
    private HashMap<Integer, Integer> studentsGradesMap;

    private static JavaCourse instance;

    private JavaCourse() {
        this.studentsGradesMap = new HashMap<>();
        this.tasksDone = 0;
        pointsScored = 0;
    }

    public static JavaCourse getInstance() {
        if (instance == null) {
            instance = new JavaCourse();
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

    @Override
    public double getAverageGrade() {
        return (double) pointsScored/tasksDone;
    }
}