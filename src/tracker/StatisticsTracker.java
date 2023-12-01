package tracker;

import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.Collections;

public class StatisticsTracker {

    JavaCourse javaCourse;
    SpringCourse springCourse;
    DSACourse dsaCourse;
    DatabasesCourse databasesCourse;

    ArrayList<Course> courseArrayList;

    private static StatisticsTracker instance;

    private StatisticsTracker() {
        javaCourse = JavaCourse.getInstance();
        springCourse = SpringCourse.getInstance();
        dsaCourse = DSACourse.getInstance();
        databasesCourse = DatabasesCourse.getInstance();
        courseArrayList =  new ArrayList<>();
        courseArrayList.add(javaCourse);
        courseArrayList.add(springCourse);
        courseArrayList.add(databasesCourse);
        courseArrayList.add(dsaCourse);
    }

    public static StatisticsTracker getInstance() {
        if (instance == null) {
            instance = new StatisticsTracker();
        }
        return instance;
    }

    public ArrayList<String> getMostPopularCourses() {
        ArrayList<Integer> coursesPopularity = new ArrayList<>();
        ArrayList<String> mostPopularCourses = new ArrayList<>();

        for (Course course : courseArrayList) {
            coursesPopularity.add(course.getEnrolledStudents());
        }

        int max = Collections.max(coursesPopularity);

        for (Course course : courseArrayList) {
            if (course.getEnrolledStudents() == max) {
                mostPopularCourses.add(course.getName());
            }
        }
        return mostPopularCourses;
    }

    public ArrayList<String> getLeastPopularCourses() {
        ArrayList<Integer> coursesPopularity = new ArrayList<>();
        ArrayList<String> leastPopularCourses = new ArrayList<>();

        for (Course course : courseArrayList) {
            coursesPopularity.add(course.getEnrolledStudents());
        }

        int min = Collections.min(coursesPopularity);

        for (Course course : courseArrayList) {
            if (course.getEnrolledStudents() == min && !getMostPopularCourses().contains(course.getName())) {
                leastPopularCourses.add(course.getName());
            }
        }
        return leastPopularCourses;
    }

    public ArrayList<String> getCoursesWithHighestActivity() {
        ArrayList<Integer> coursesActivity = new ArrayList<>();
        ArrayList<String> coursesWithHighestActivity = new ArrayList<>();

        for (Course course : courseArrayList) {
            coursesActivity.add(course.getTaskDone());
        }

        int max = Collections.max(coursesActivity);

        for (Course course : courseArrayList) {
            if (course.getTaskDone() == max) {
                coursesWithHighestActivity.add(course.getName());
            }
        }
        return coursesWithHighestActivity;
    }

    public ArrayList<String> getCoursesWithLowestActivity() {
        ArrayList<Integer> coursesActivity = new ArrayList<>();
        ArrayList<String> coursesWithLowestActivity = new ArrayList<>();

        for (Course course : courseArrayList) {
            coursesActivity.add(course.getTaskDone());
        }

        int min = Collections.min(coursesActivity);

        for (Course course : courseArrayList) {
            if (course.getTaskDone() == min && !getCoursesWithHighestActivity().contains(course.getName())) {
                coursesWithLowestActivity.add(course.getName());
            }
        }
        return coursesWithLowestActivity;
    }

    public ArrayList<String> getEasiestCourses() {
        ArrayList<Double> coursesDifficultyLevels = new ArrayList<>();
        ArrayList<String> easiestCourses = new ArrayList<>();

        for (Course course : courseArrayList) {
            coursesDifficultyLevels.add(course.getAverageGrade());
        }

        Double max = Collections.max(coursesDifficultyLevels);

        for (Course course : courseArrayList) {
            if (course.getAverageGrade() == max) {
                easiestCourses.add(course.getName());
            }
        }
        return easiestCourses;
    }

    public ArrayList<String> getHardestCourses() {
        ArrayList<Double> coursesDifficultyLevels = new ArrayList<>();
        ArrayList<String> hardestCourses = new ArrayList<>();

        for (Course course : courseArrayList) {
            coursesDifficultyLevels.add(course.getAverageGrade());
        }

        Double min = Collections.min(coursesDifficultyLevels);

        for (Course course : courseArrayList) {
            if (course.getAverageGrade() == min && !getEasiestCourses().contains(course.getName())) {
                hardestCourses.add(course.getName());
            }
        }
        return hardestCourses;
    }
}
