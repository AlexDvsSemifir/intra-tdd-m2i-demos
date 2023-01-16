package fr.semifir.tdd.calculatrice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatriceTest {

    private Calculatrice calculatrice;

    @BeforeEach
    void setUp() {
        calculatrice = new Calculatrice();
    }

    @ParameterizedTest
    @ValueSource(floats = {1, 2, 3, 4, 5})
    void additionDeDeuxEntiersPositifs(float a) {
        // Given
        float expected = a + a;

        // When
        float actual = calculatrice.addition(a, a);

        // Then
        assertEquals(expected, actual);
    }
}