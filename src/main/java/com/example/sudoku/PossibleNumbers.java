package com.example.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

record PossibleNumbers (Board board) {

    List<FieldNumber> possibleNumbers(int row, int col) {
        var smallBoard = BoardFactory.of(board, row / 3, col /3 );

        var numbersFilled = new HashSet<>(smallBoard.getFilledNumbers());
        numbersFilled.addAll(List.of(BoardFactory.ofRowLine(board, row).fieldNumbers()));
        numbersFilled.addAll(List.of(BoardFactory.ofColLine(board, col).fieldNumbers()));

        return getNumbersNotIn(numbersFilled);
    }

    private List<FieldNumber> getNumbersNotIn(Set<FieldNumber> taken) {
        var l = new ArrayList<FieldNumber>();

        for (int i = 1; i <= 9; i++) {
            var number = new FieldNumber(i);
            if (taken.contains(number)) {
                continue;
            }
            l.add(number);
        }
        return l;
    }

}
