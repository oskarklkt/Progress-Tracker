package tracker;

import java.util.HashMap;

public class DatabasesCourse extends Course {
    private HashMap<Integer, Integer> studentsGradesMap;

    private static DatabasesCourse instance;

    private DatabasesCourse() {
        this.studentsGradesMap = new HashMap<>();
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
}
