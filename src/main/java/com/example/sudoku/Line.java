package com.example.sudoku;

import java.util.HashSet;

record Line(FieldNumber[] fieldNumbers) implements BoardVerification {

    @Override
    public boolean areAllFieldsFilled() {
        for (int i = 0; i < 9; i++) {
            if (fieldNumbers[i].isUnknown()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean noDuplication() {
        var recorded = new HashSet<FieldNumber>();
        for (int i = 0; i < 9; i++) {
            var number = fieldNumbers[i];
            if (number.isUnknown()) {
                continue;
            }
            if (!recorded.add(number)) {
                return false;
            }
        }
        return true;
    }
}
