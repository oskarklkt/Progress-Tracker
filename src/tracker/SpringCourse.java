package tracker;

import java.util.HashMap;

public class SpringCourse {
    static HashMap<Integer, Integer> studentsGradesMap = new HashMap<>();

    public static int getGradeById(int id) {
        return studentsGradesMap.get(id);
    }

    public static void setGradeById(int id, int grade) {
        studentsGradesMap.put(id, grade);
    }
}
