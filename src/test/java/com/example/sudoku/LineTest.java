package com.example.sudoku;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.example.sudoku.FieldNumber.of;
import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @CsvSource(value = {
            "534678912,true",
            "114678912,true",
            "534678910,false"
    })
    void areAllFieldsFilled(String input, Boolean expected) {
        // given
        var line = new Line(of(input));
        // when
        var result = line.areAllFieldsFilled();
        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "534678912,true",
            "034678912,true",
            "033678912,false",
    })
    void noDuplications(String input, Boolean expected) {
        // given
        var line = new Line(of(input));
        // when
        var result = line.noDuplication();
        // then
        assertThat(result).isEqualTo(expected);
    }
}