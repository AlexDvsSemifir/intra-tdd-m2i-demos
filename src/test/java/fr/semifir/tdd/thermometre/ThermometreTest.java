package fr.semifir.tdd.thermometre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThermometreTest {

    Thermometre thermometre;

    @BeforeEach
    void setUp() {
        thermometre = new Thermometre();
    }

    @Test
    void doitRetournerZeroSiVide() {
        int[] temperatures = new int[1];

        int resultat = thermometre.getTemperatureLaPlusProcheDeZero(temperatures);
        assertEquals(0, resultat);
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
        int[] temperatures = new int[3];
        temperatures[0] = 4;
        temperatures[1] = 2;
        temperatures[2] = 5;

        int resultat = thermometre.getTemperatureLaPlusProcheDeZero(temperatures);
        assertEquals(2, resultat);
    }

    @Test
    void doitRetournerNombreNegatifPlusProcheDeZero() {
        int[] temperatures = new int[3];
        temperatures[0] = -4;
        temperatures[1] = -2;
        temperatures[2] = -5;

        int resultat = thermometre.getTemperatureLaPlusProcheDeZero(temperatures);
        assertEquals(-2, resultat);
    }

    @Test
    void doitRetournerLaValeurPositiveSiLaDistanceEstIdentique() {
        int[] temperatures = new int[2];
        temperatures[0] = -1;
        temperatures[1] = 1;

        int resultat = thermometre.getTemperatureLaPlusProcheDeZero(temperatures);
        assertEquals(1, resultat);
    }
}
