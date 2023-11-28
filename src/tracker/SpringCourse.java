package tracker;

import java.util.HashMap;

public class SpringCourse extends Course{
    private HashMap<Integer, Integer> studentsGradesMap;

    private static SpringCourse instance;

    private SpringCourse() {
        this.studentsGradesMap = new HashMap<>();
    }

    public static SpringCourse getInstance() {
        if (instance == null) {
            instance = new SpringCourse();
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
