package com.example.sudoku;

import java.util.Objects;

record Board(FieldNumber[][] items) {
    Board(FieldNumber[][] items) {
        this.items = items;
        Objects.requireNonNull(items);
        if (items.length != 9) {
            throw new IllegalArgumentException("wrong length");
        }
        for (int i = 0; i < 9; i++) {
            if (items[i].length != 9) {
                throw new IllegalArgumentException("wrong length");
            }
        }
    }

    static Board of(Integer[][] items) {
        FieldNumber[][] fieldNumbers = new FieldNumber[items.length][items[0].length];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                fieldNumbers[i][j] = new FieldNumber(items[i][j]);
            }
        }
        return new Board(fieldNumbers);
    }

    static Board of(String board) {
        FieldNumber[][] fieldNumbers = new FieldNumber[9][9];
        var elements = board.split("\n");
        for (var i = 0; i < elements.length; i++) {
            for (int j = 0; j < 9; j++) {
                fieldNumbers[i][j] = new FieldNumber(Character.getNumericValue(elements[i].charAt(j)));
            }
        }
        return new Board(fieldNumbers);
    }
}
