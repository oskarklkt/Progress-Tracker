package tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexCheckerTest {

    @Test
    void oskarShouldReturnTrue() {
        RegexChecker regexChecker = new RegexChecker();
        assertTrue(regexChecker.checkFirstName("Oskar"));
    }

    @Test
    void JeanClaudeShouldReturnTrue() {
        RegexChecker regexChecker = new RegexChecker();
        assertTrue(regexChecker.checkFirstName("Jean-Claude"));
    }

    @Test
    void MarcinShouldReturnTrue() {
        RegexChecker regexChecker = new RegexChecker();
        assertTrue(regexChecker.checkFirstName("Marcin"));
    }

    @Test
    void ONeillShouldReturnTrue() {
        RegexChecker regexChecker = new RegexChecker();
        assertTrue(regexChecker.checkFirstName("O'Neill"));
    }

    @Test
    void NowakShouldReturnTrue() {
        RegexChecker regexChecker = new RegexChecker();
        assertTrue(regexChecker.checkLastName("Nowak"));
    }

    @Test
    void VanDerSaarShouldReturnTrue() {
        RegexChecker regexChecker = new RegexChecker();
        assertTrue(regexChecker.checkLastName("Van Der Saar"));
    }

    @Test
    @DisplayName("maryj@google.com should return true")
    void email1ShouldReturnTrue() {
        RegexChecker regexChecker = new RegexChecker();
        assertTrue(regexChecker.checkEmail("maryj@google.com"));
    }

    @Test
    @DisplayName("jc@google.it should return true")
    void email2ShouldReturnTrue() {
        RegexChecker regexChecker = new RegexChecker();
        assertTrue(regexChecker.checkEmail("jc@google.it"));
    }
}