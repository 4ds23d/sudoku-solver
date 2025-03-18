package com.example.sudoku;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FieldNumberTest {
    @Test
    void toStringWorks() {
        // given
        var fieldNr = new FieldNumber(2);

        // when

        // then
        assertThat(fieldNr.toString()).isEqualTo("2");
    }
}