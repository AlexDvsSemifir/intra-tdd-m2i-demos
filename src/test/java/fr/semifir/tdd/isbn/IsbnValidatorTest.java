package fr.semifir.tdd.isbn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class IsbnValidatorTest {
    private IsbnValidator isbnValidator;
    @ParameterizedTest
    @ValueSource(strings = {"1491926309", "2100825208"})
    void verifierSiIsbnEstValide(String isbnAVerifier) {
        isbnValidator = new IsbnValidator();

        boolean resultat = isbnValidator.verifierIsbn(isbnAVerifier);

        assertTrue(resultat, "Le numéro Isbn " + isbnAVerifier + " est valide");
    }

    @Test
    void verifierSiIsbnEstInvalide() {
        isbnValidator = new IsbnValidator();

        boolean resultat = isbnValidator.verifierIsbn("1491926308");

        assertFalse(resultat, "Le numéro Isbn est valide");
    }

    @Test
    void verifierSiISbnTermineParXEstValide() {
        isbnValidator = new IsbnValidator();

        boolean resultat = isbnValidator.verifierIsbn("043942089X");

        assertTrue(resultat, "Le numéro Isbn  est valide");
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678910", "11"})
    void isbnDoitEtreDeDixCaracteres(String isbnAVerifier) {
        isbnValidator = new IsbnValidator();

        Exception message = assertThrows(IllegalArgumentException.class, () -> isbnValidator.verifierIsbn(isbnAVerifier)) ;

        assertEquals(IllegalArgumentException.class, message.getClass());
        assertEquals("L'ISBN doit contenir 10 caractères", message.getMessage());

    }
}
