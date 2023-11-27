package tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class RegexChecker {

    public boolean checkFirstName(String firstName) {
        return firstName.matches("[a-zA-Z]+[,.'-]?[a-zA-Z]*[a-zA-Z]");
    }

    public boolean checkLastName(String lastName) {

        if (lastName.matches(".*[ ,.'-][ ,.'-].*")) {
            return false;
        }

        return lastName.matches("[a-zA-Z]+[a-zA-Z ',.-]*[a-zA-Z]");
    }

    public boolean checkEmail(String email) {
        return email.matches("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+[.][a-zA-Z0-9.-]+");
    }

    public boolean checkAddPointsInput(String input) {
        ArrayList<Integer> inputList = new ArrayList<>();
        try {
            for (String s : input.split(" ")) {
                inputList.add(Integer.parseInt(s));
            }
        } catch (Exception e) {
            System.out.println("Incorrect points format");
            Menu.addPoints();
            return false;
        }
        if (inputList.size() != 5) {
            System.out.println("Incorrect points format");
            Menu.addPoints();
            return false;
        }
        if (inputList.get(0) < Student.getNextId() && inputList.get(0) >= 1) {
            System.out.println("Points updated");
        } else {
            System.out.printf("No student is found for id=%s\n", inputList.get(0));
            Menu.addPoints();
            return false;
        }
        return true;
    }
}
