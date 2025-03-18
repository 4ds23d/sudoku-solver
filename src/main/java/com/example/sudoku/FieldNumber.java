package com.example.sudoku;

import java.util.stream.IntStream;

record FieldNumber(int nr) {
    FieldNumber {
        if (nr > 9 || nr < 0) {
            throw new IllegalArgumentException("Invalid number");
        }
    }

    boolean isUnknown() {
        return nr == 0;
    }

    boolean isNumber() {
        return nr > 0;
    }

    @Override
    public String toString() {
        return "" + nr;
    }

    static FieldNumber[] of(String numbers) {
        return IntStream.range(0, numbers.length())
                .mapToObj(i -> Character.getNumericValue(numbers.charAt(i)))
                .map(FieldNumber::new)
                .toArray(FieldNumber[]::new);

    }
}
