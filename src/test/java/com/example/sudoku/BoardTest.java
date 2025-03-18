package com.example.sudoku;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {
    String solvedBoard = """
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
    void equal() {
        // then
        assertThat(BoardFactory.of(solvedBoard)).isEqualTo(BoardFactory.of(solvedBoard));
        assertThat(BoardFactory.of(solvedBoard)).isNotEqualTo(BoardFactory.of("""
        534678912
        672195348
        198342567
        859761423
        426853791
        713924856
        961537284
        287419635
        345286170"""));

    }

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
        var bord = BoardFactory.of(board);

        // then
        assertThat(bord.areAllFieldsFilled()).isFalse();
        assertThat(bord.noDuplication()).isTrue();
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
        var b = BoardFactory.of(board);

        // then
        assertThat(b.areAllFieldsFilled()).isTrue();
        assertThat(b.noDuplication()).isTrue();
    }

    @Nested
    class Lines {
        @Test
        void getRow0() {
            // given
            var board = BoardFactory.of(solvedBoard);

            // when
            var line = BoardFactory.ofRowLine(board, 0);

            // then
            assertThat(line).isEqualToComparingFieldByField(new Line(FieldNumber.of("534678912")));
        }

        @Test
        void getRow1() {
            // given
            var board = BoardFactory.of(solvedBoard);

            // when
            var line = BoardFactory.ofRowLine(board, 1);

            // then
            assertThat(line).isEqualToComparingFieldByField(new Line(FieldNumber.of("672195348")));
        }

        @Test
        void getCol0() {
            // given
            var board = BoardFactory.of(solvedBoard);

            // when
            var line = BoardFactory.ofColLine(board, 0);

            // then
            assertThat(line).isEqualToComparingFieldByField(new Line(FieldNumber.of("561847923")));
        }

        @Test
        void getCol1() {
            // given
            var board = BoardFactory.of(solvedBoard);

            // when
            var line = BoardFactory.ofColLine(board, 1);

            // then
            assertThat(line).isEqualToComparingFieldByField(new Line(FieldNumber.of("379521684")));
        }
    }

}