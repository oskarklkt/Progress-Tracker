package tracker;

import java.util.HashMap;

public class JavaCourse extends Course {
    private HashMap<Integer, Integer> studentsGradesMap;

    private static JavaCourse instance;

    private JavaCourse() {
        this.studentsGradesMap = new HashMap<>();
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
}
