package com.example.sudoku;

import java.util.*;

class BruteForce implements Algorithm {

    @Override
    public Board solve(Board board) {
        var steps = getNextPosition(board);
        if (steps.isEmpty()) {
            return board;
        }
        var positionWithOptions = steps.get();
        return solve(board, positionWithOptions.position(), positionWithOptions.variants());
    }

    private Optional<PositionWithOptions> getNextPosition(Board board) {
        var possibleElements = new HashMap<Position, List<FieldNumber>>();
        var optimal = new PriorityQueue<Position>(Comparator.comparingInt(k -> possibleElements.get(k).size()));

        var possibleNumbers = new PossibleNumbers(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.isUnknown(i, j)) {
                    var position = new Position(i, j);
                    possibleElements.put(position, possibleNumbers.possibleNumbers(i, j));
                    optimal.add(position);
                }
            }
        }

        if (optimal.isEmpty()) {
            return Optional.empty();
        }
        var position = optimal.poll();
        return Optional.of(new PositionWithOptions(position, possibleElements.get(position)));
    }

    private Board solve(Board board, Position position, List<FieldNumber> fieldNumbers) {
        for (var number : fieldNumbers) {
            var newBoard = board.putNumber(number, position.row(), position.col());
            if (newBoard.isComplete()) {
                return newBoard;
            }
            var steps = getNextPosition(newBoard);
            if (steps.isEmpty()) {
                return null;
            }
            var positionWithOptions = steps.get();
            return solve(newBoard, positionWithOptions.position(), positionWithOptions.variants());
        }

        return null;
    }
}

record Position(int row, int col) {
}

record PositionWithOptions(Position position, List<FieldNumber> variants) {
}
