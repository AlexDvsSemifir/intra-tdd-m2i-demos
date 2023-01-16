package fr.semifir.tdd.isbn;


public class IsbnValidator {
    public boolean verifierIsbn(String isbnAVerifier) throws IllegalArgumentException {

        if (isbnAVerifier.length() != 10) {
            throw new IllegalArgumentException("L'ISBN doit contenir 10 caractères");
        }

        int isbn = Integer.parseInt(isbnAVerifier.substring(0, 9));

        int total = calculerPoids(isbn);

        total += verifierDernierCaratere(isbnAVerifier);

        return verifierModuloDeOnze(total);
    }

    /**
     * Calcule le poids de chaque nombre
     * @param isbn
     * @return
     */
    private int calculerPoids(int isbn) {
        int total = 0;
        for (int index = 1; index < 10; index++) {
            total += (isbn % 10) * (index + 1);
            isbn /= 10;
        }
        return total;
    }

    /**
     * Vérifie le dernier caratère du nombre.
     * @param isbnAVerifier
     * @return
     */
    private int verifierDernierCaratere(String isbnAVerifier) {
        if (isbnAVerifier.charAt(9) == 'X') {
            return 10;
        } else {
            return Character.getNumericValue(isbnAVerifier.charAt(9));
        }
    }

    private boolean verifierModuloDeOnze(int total) {
        if (total % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
