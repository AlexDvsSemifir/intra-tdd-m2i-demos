package fr.semifir.tdd.thermometre;

public class Thermometre {
    public int getTemperatureLaPlusProcheDeZero(int[] temperatures) {
        int plusProcheDeZero = temperatures[0];

        if (temperatures.length > 10000) {
            throw new IllegalArgumentException("Le tableau ne peut contenir que 10 000 valeurs");
        }

        for (int temperature : temperatures) {
            if (Math.abs(temperature) < Math.abs(plusProcheDeZero)) {
                plusProcheDeZero = temperature;
            } else if (Math.abs(temperature) == Math.abs(plusProcheDeZero)) {
                if (temperature > 0) {
                    plusProcheDeZero = temperature;
                }
            }
        }
        return plusProcheDeZero;
    }
}
