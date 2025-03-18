package com.example.sudoku;

import java.util.List;
import java.util.stream.IntStream;

class BoardFactory {
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

    static SmallBoard of(Board board, Integer row, Integer col) {
        FieldNumber[][] fieldNumbers = new FieldNumber[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(board.items()[3 * row + i], 3 * col, fieldNumbers[i], 0, 3);
        }
        return new SmallBoard(fieldNumbers);
    }

    static List<SmallBoard> ofSmallBoards(Board board) {
        return List.of(
                BoardFactory.of(board, 0, 0),
                BoardFactory.of(board, 0, 1),
                BoardFactory.of(board, 0, 2),
                BoardFactory.of(board, 1, 0),
                BoardFactory.of(board, 1, 1),
                BoardFactory.of(board, 1, 2),
                BoardFactory.of(board, 2, 0),
                BoardFactory.of(board, 2, 1),
                BoardFactory.of(board, 2, 2)
        );
    }

    static Line ofRowLine(Board board, int nr) {
        var fieldNumbers = new FieldNumber[9];
        System.arraycopy(board.items()[nr], 0, fieldNumbers, 0, 9);
        return new Line(fieldNumbers);
    }

    static Line ofColLine(Board board, int nr) {
        var fieldNumbers = new FieldNumber[9];
        for (int i = 0; i < 9; i++) {
            fieldNumbers[i] = board.items()[i][nr];
        }
        return new Line(fieldNumbers);
    }

    static List<Line> ofRowLines(Board board) {
        return IntStream.range(0, 9).mapToObj(el -> ofRowLine(board, el)).toList();
    }

    static List<Line> ofColLines(Board board) {
        return IntStream.range(0, 9).mapToObj(el -> ofColLine(board, el)).toList();
    }
}
