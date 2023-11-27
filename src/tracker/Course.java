package tracker;

import java.util.HashMap;

public abstract class Course {
    public static HashMap<Integer, Integer> studentsGradesMap;

    public static void getGradeById(int id) {
        studentsGradesMap.get(id);
    }

    public static void setGradeById(int id, int grade) {
        studentsGradesMap.put(id, grade);
    }


}
