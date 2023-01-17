package fr.semifir.tdd.refactorIsbn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsbnValidatorTest {

    @Test
    void checkAValidISBN10() {
        IsbnValidator validator = new IsbnValidator();
        boolean result = validator.checkISBN("2412066868");
        assertTrue(result, "first value");
    }

    @Test
    void checkInvalidISBN10() {
        IsbnValidator validator = new IsbnValidator();
        boolean result = validator.checkISBN("2412066869");
        assertFalse(result, "first value");
    }

    @Test
    void checkAValidISBN13() {
        IsbnValidator validator = new IsbnValidator();
        boolean result = validator.checkISBN("9782412066867");
        assertTrue(result, "first value");
    }

    @Test
    void checkInvalidISBN13() {
        IsbnValidator validator = new IsbnValidator();
        boolean result = validator.checkISBN("9782412066868");
        assertFalse(result, "first value");
    }

    @Test
    void checkAValidISBN10WithX() {
        IsbnValidator validator = new IsbnValidator();
        boolean result = validator.checkISBN("043942089X");
        assertTrue(result, "first value");
    }

    @Test
    void checkInvalidISBN10WithX() {
        IsbnValidator validator = new IsbnValidator();
        boolean result = validator.checkISBN("043942087X");
        assertFalse(result, "first value");
    }

    @Test
    void checkInvalidISBNVithXNotAtTheEnd() {
        IsbnValidator validator = new IsbnValidator();
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("04394208X9"));
    }

    @Test
    void checkInvalildISBNWithYAtTheEnd() {
        IsbnValidator validator = new IsbnValidator();
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("043942089Y"));
    }

    @Test
    void checkInvalidISBNWithLessThan10Digits() {
        IsbnValidator validator = new IsbnValidator();
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("24120"));
    }

    @Test
    void checkInvalidISBNWithMoreThan10Digits() {
        IsbnValidator validator = new IsbnValidator();
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("24120668690000"));
    }
}
