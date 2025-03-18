package com.example.sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void canCreateABoard() {
        // given
        var board = """
                034000600
                002600080
                068300007
                003001005
                059060072
                000520046
                205906000
                000408050
                000007004
                """;
        var bord = Board.of(board);
    }

    @Test
    void solvedSudoku() {
        // given
        var board = """
        534678912
        672195348
        198342567
        859761423
        426853791
        713924856
        961537284
        287419635
        345286179""";

        // when
        var b = Board.of(board);

        // then
    }

}