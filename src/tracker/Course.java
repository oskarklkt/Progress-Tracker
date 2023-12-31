package tracker;

import java.util.ArrayList;
import java.util.Map;

public abstract class Course {
    int MAX_POINTS;

    public abstract int getGradeById(int id);

    public abstract void setGradeById(int id, int grade);

    public abstract Map<Integer, Integer> getStudentsGradesMap();

    public abstract int getEnrolledStudents();

    public abstract void incrementTaskDone();

    public abstract int getTaskDone();

    public abstract void incrementPointsScored(int score);

    public abstract double getAverageGrade();

    public abstract String getName();

    public abstract void printBestStudents();

    public abstract ArrayList<Integer> getIdsOfStudentsToNotify();
}