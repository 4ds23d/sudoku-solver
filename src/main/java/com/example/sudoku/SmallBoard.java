package com.example.sudoku;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

record SmallBoard(FieldNumber[][] fieldNumbers) implements BoardVerification {
    SmallBoard {
        if (fieldNumbers.length != 3
            || fieldNumbers[0].length != 3
            || fieldNumbers[1].length != 3
            || fieldNumbers[2].length != 3
            ) {
            throw new IllegalArgumentException("Illegal small board");
        }
    }

    @Override
    public boolean areAllFieldsFilled() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (fieldNumbers[i][j].isUnknown()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean hasDuplication() {
        var recorded = new HashSet<FieldNumber>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                var number = fieldNumbers[i][j];
                if (number.isUnknown()) {
                    continue;
                }
                if (!recorded.add(number)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean noDuplication() {
        return !hasDuplication();
    }

    List<FieldNumber> getFilledNumbers() {
        var list = new ArrayList<FieldNumber>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                var nr = fieldNumbers[i][j];
                if (nr.isNumber()) {
                    list.add(nr);
                }
            }
        }
        return list;
    }
}
