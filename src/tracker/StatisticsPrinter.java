package tracker;

import java.util.ArrayList;

public class StatisticsPrinter {
    private static StatisticsPrinter instance;

    private StatisticsPrinter() {
    }

    public static StatisticsPrinter getInstance() {
        if (instance == null) {
            instance = new StatisticsPrinter();
        }
        return instance;
    }


    public String printStatistics(ArrayList<String> arrayList) {
        if (arrayList.isEmpty()) {
            return "n/a";
        }

        StringBuilder s = new StringBuilder(s = new StringBuilder(arrayList.get(0)));
        arrayList.remove(0);
        while (!arrayList.isEmpty()) {
            s.append(", ").append(arrayList.get(0));
            arrayList.remove(0);
        }
        return s.toString();
    }

    public boolean emptyPrinter() {
        if (JavaCourse.getInstance().getEnrolledStudents() == 0 &&
                SpringCourse.getInstance().getEnrolledStudents() == 0 &&
                DatabasesCourse.getInstance().getEnrolledStudents() == 0 &&
                DSACourse.getInstance().getEnrolledStudents() == 0 ) {
            System.out.println("Most popular: n/a\n" +
                    "Least popular: n/a\n" +
                    "Highest activity: n/a\n" +
                    "Lowest activity: n/a\n" +
                    "Easiest course: n/a\n" +
                    "Hardest course: n/a");
            return true;
        }
        return false;
    }
}
