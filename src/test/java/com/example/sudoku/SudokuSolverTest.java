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

    @Test
    void brokenSudoku() {
        // given
        String board = """
        034678912
        572195348
        108342567
        859761423
        426853791
        713924856
        961537284
        287419635
        345286179""";
        var b = BoardFactory.of(board);
        var alg = new SudokuSolver();

        // when
        var solvedBoard = alg.solve(b);

        // then
        assertThat(solvedBoard).isNull();
    }

    @Test
    void solve2() {
        // given
        String board = """
        004678912
        672195348
        198342567
        809761420
        426853791
        713924856
        961537284
        287419635
        045286179""";
        var b = BoardFactory.of(board);
        var alg = new SudokuSolver();

        // when
        var solvedBoard = alg.solve(b);

        // then
        assertThat(solvedBoard).isEqualTo(BoardFactory.of(SOLVED));
    }

    @Test
    void solveRealyHard() {
        // given
        String board = """
        000000002
        000000000
        000000000
        000000000
        000000000
        000000000
        000000000
        000000005
        000000000""";
        var b = BoardFactory.of(board);
        var alg = new SudokuSolver();

        // when
        var solvedBoard = alg.solve(b);

        // then
        assertThat(solvedBoard).isNotNull();
    }

    @Test
    void t1() {
        // given
        String board = """
                483021650
                967340821
                251806493
                000000000
                000504138
                000798245
                000089514
                000253769
                000417382""";
        var b = BoardFactory.of(board);
        var alg = new SudokuSolver();

        // when
        var solvedBoard = alg.solve(b);

        // then
        assertThat(solvedBoard).isEqualTo(BoardFactory.of("""
                483921657
                967345821
                251876493
                548132976
                729564138
                136798245
                372689514
                814253769
                695417382"""));
    }
}