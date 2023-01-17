package fr.semifir.tdd.refactorIsbn;

public class IsbnValidator {

    public static final int ISBN13Length = 13;
    public static final int ISBN10Length = 10;

    public boolean checkISBN(String isbn) {
        if (isbn.length() == ISBN13Length) {
            return checkISBN13(isbn);
        }
        if (isbn.length() == ISBN10Length) {
            return checkISBN10(isbn);
        }
        throw new NumberFormatException();
    }

    private boolean checkISBN13(String isbn) {
        int total = 0;
        for (int index = 0; index < ISBN13Length; index++) {
            int numericValue = Character.getNumericValue(isbn.charAt(index));
            if (index % 2 == 0) {
                total += numericValue;
            } else {
                total += numericValue * 3;
            }
        }
        return isMultipleOf10(total);
    }

    private boolean checkISBN10(String isbn) {
        int total = 0;
        for (int index = 0; index < ISBN10Length; index++) {
            if (Character.isDigit(isbn.charAt(index))) {
                total += Character.getNumericValue(isbn.charAt(index)) * (ISBN10Length - index);
            } else if (index == 9 && isbn.charAt(index) == 'X') {
                total += 10;
            } else {
                throw new NumberFormatException();
            }
        }
        return isMultipleOf11(total);
    }

    private static boolean isMultipleOf11(int total) {
        return total % 11 == 0;
    }

    private static boolean isMultipleOf10(int total) {
        return total % 10 == 0;
    }
}
