package fr.semifir.tdd.thermometre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThermometreTest {

    Thermometre thermometre;
    int[] temperatures = new int[3];

    @BeforeEach
    void setUp() {
        thermometre = new Thermometre();
    }

    @Test
    void doitRetournerZeroSiVide() {

        int resultat = thermometre.getTemperatureLaPlusProcheDeZero(temperatures);
        assertTrue(resultat == 0);
    }

    @Test
    void doitRetournerUneErreurSiPlusDeDixmilleEntrees() {
        int[] temperatures = new int[10001];

        for(int i = 1;i <= 10001; i++) {
            temperatures[i - 1] = i;
        }


        Exception exception = assertThrows(IllegalArgumentException.class, () -> thermometre.getTemperatureLaPlusProcheDeZero(temperatures));
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    void doitRetournerNombrePositifLePlusProcheDeZero() {
        temperatures[0] = 4;
        temperatures[1] = 2;
        temperatures[2] = 5;

        int resultat = thermometre.getTemperatureLaPlusProcheDeZero(temperatures);
        assertEquals(2, resultat);
    }

    @Test
    void doitRetournerNombreNegatifPlusProcheDeZero() {
        temperatures[0] = -4;
        temperatures[1] = -2;
        temperatures[2] = -5;

        int resultat = thermometre.getTemperatureLaPlusProcheDeZero(temperatures);
        assertEquals(-2, resultat);
    }
}
