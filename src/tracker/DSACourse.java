package tracker;

import java.util.HashMap;

public class DSACourse extends Course{
    private HashMap<Integer, Integer> studentsGradesMap;

    private static DSACourse instance;

    private DSACourse() {
        this.studentsGradesMap = new HashMap<>();
    }

    public static DSACourse getInstance() {
        if (instance == null) {
            instance = new DSACourse();
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
