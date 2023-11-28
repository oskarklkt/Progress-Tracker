package tracker;

import java.util.Map;

public abstract class Course {

    public abstract int getGradeById(int id);

    public abstract void setGradeById(int id, int grade);

    public abstract Map<Integer, Integer> getStudentsGradesMap();
}
