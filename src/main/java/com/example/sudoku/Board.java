package com.example.sudoku;

import java.util.Arrays;
import java.util.Objects;

record Board(FieldNumber[][] items) implements BoardVerification {
    Board {
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

    @Override
    public boolean areAllFieldsFilled() {
        return BoardFactory.ofRowLines(this).stream().allMatch(Line::areAllFieldsFilled)
               && BoardFactory.ofColLines(this).stream().allMatch(Line::areAllFieldsFilled)
               && BoardFactory.ofSmallBoards(this).stream().allMatch(SmallBoard::areAllFieldsFilled);
    }

    @Override
    public boolean noDuplication() {
        return BoardFactory.ofSmallBoards(this).stream().allMatch(SmallBoard::noDuplication)
               && BoardFactory.ofColLines(this).stream().allMatch(Line::noDuplication)
               && BoardFactory.ofSmallBoards(this).stream().allMatch(SmallBoard::noDuplication);
    }

    Board putNumber(FieldNumber number, int row, int col) {
        var items = new FieldNumber[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(this.items()[i], 0, items[i], 0, 9);
        }
        items[row][col] = number;
        return new Board(items);
    }

    boolean isNumber(int row, int col) {
        return items[row][col].isNumber();
    }

    boolean isUnknown(int row, int col) {
        return items[row][col].isUnknown();
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(items);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Board board)) return false;
        return Arrays.deepEquals(items, board.items);
    }
}
