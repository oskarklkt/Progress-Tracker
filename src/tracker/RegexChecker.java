package tracker;

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
}
