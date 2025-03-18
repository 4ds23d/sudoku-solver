package com.example.sudoku;

record FieldNumber(int nr) {
    FieldNumber {
        if (nr > 9 || nr < 0) {
            throw new IllegalArgumentException("Invalid number");
        }
    }
}
