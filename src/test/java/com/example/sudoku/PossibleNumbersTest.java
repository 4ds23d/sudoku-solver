package com.example.sudoku;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PossibleNumbersTest {


    @ParameterizedTest
    @CsvSource(value = {
            "0,0",
            "1,0",
            "5,3",
            "8,8"
    })
    void possibleNumber(int row, int col) {
        // given
        String board = """
        534678912
        672195348
        198340567
        859761423
        426853791
        713924856
        961537284
        287419635
        345286179""";
        var possibleNumber = aPossibleValue(board);

        // when
        var result = possibleNumber.possibleNumbers(row, col);

        // then
        assertThat(result).hasSize(0);
    }

    private PossibleNumbers aPossibleValue(String board) {
        return new PossibleNumbers(BoardFactory.of(board));
    }

    @Test
    void becauseOfSmallBoardLimitation() {
        // given
        String board = """
        534000000
        600000000
        198000000
        000761423
        000853791
        000924856
        000537284
        000419635
        000286179""";
        var possibleNumber = aPossibleValue(board);

        // when
        var result = possibleNumber.possibleNumbers(1, 1);

        // then
        assertThat(result).containsExactlyInAnyOrder(FieldNumber.of("27"));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0,0,5",
            "1,1,7",
            "2,2,8"
    })
    void possibleBecauseRowAndColumnLimit(int col, int row, String expectedNumbers) {
        // given
        String board = """
        034678912
        602195348
        190340567
        850761423
        426853791
        713924856
        961537284
        287419635
        345286179""";
        var possibleNumber = aPossibleValue(board);

        // when
        var result = possibleNumber.possibleNumbers(row, col);

        // then
        assertThat(result).containsExactlyInAnyOrder(FieldNumber.of(expectedNumbers));
    }
}