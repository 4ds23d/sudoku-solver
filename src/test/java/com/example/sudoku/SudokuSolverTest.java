package com.example.sudoku;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SudokuSolverTest {
    private static final String SOLVED = """
        534678912
        672195348
        198342567
        859761423
        426853791
        713924856
        961537284
        287419635
        345286179""";

    @Test
    void checkAlreadySolved() {
        // given
        String board = """
        534678912
        672195348
        198342567
        859761423
        426853791
        713924856
        961537284
        287419635
        345286179""";
        var b = BoardFactory.of(board);
        var alg = new SudokuSolver();

        // when
        var solved = alg.solve(b);

        // then
        assertThat(solved).isEqualTo(BoardFactory.of(SOLVED));
    }

    @Test
    void solve() {
        // given
        String board = """
        500608902
        600005040
        100042067
        800700403
        406050091
        003020050
        900507204
        207410605
        040080009""";
        var b = BoardFactory.of(board);
        var alg = new SudokuSolver();

        // when
        var solvedBoard = alg.solve(b);

        // then
        assertThat(solvedBoard).isEqualTo(BoardFactory.of(SOLVED));
    }
}