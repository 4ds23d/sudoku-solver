package com.example.sudoku;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

class SmallBoardTest {
    static SmallBoard complete = new SmallBoard(new FieldNumber[][]{
            {new FieldNumber(1), new FieldNumber(2), new FieldNumber(3), },
            {new FieldNumber(4), new FieldNumber(5), new FieldNumber(6), },
            {new FieldNumber(7), new FieldNumber(8), new FieldNumber(9)  }
    });

    static SmallBoard invalid = new SmallBoard(new FieldNumber[][]{
            {new FieldNumber(0), new FieldNumber(1), new FieldNumber(2), },
            {new FieldNumber(3), new FieldNumber(1), new FieldNumber(0), },
            {new FieldNumber(0), new FieldNumber(0), new FieldNumber(0)  }
    });

    static SmallBoard incomplete = new SmallBoard(new FieldNumber[][]{
            {new FieldNumber(0), new FieldNumber(1), new FieldNumber(2), },
            {new FieldNumber(3), new FieldNumber(0), new FieldNumber(0), },
            {new FieldNumber(0), new FieldNumber(0), new FieldNumber(0)  }
    });

    @ParameterizedTest()
    @MethodSource("data")
    void areAllFieldsFilled(TestData tes) {
        // when
        var result = tes.smallBoard.areAllFieldsFilled();

        // then
        assertThat(result).isEqualTo(tes.areAllFieldsFilled);
    }

    @ParameterizedTest()
    @MethodSource("data")
    void hasDuplication(TestData tes) {
        // when
        var result = tes.smallBoard.hasDuplication();

        // then
        assertThat(result).isEqualTo(tes.hasDuplication);
    }

    static Iterable<TestData> data() {
        return List.of(
                new TestData(complete, true, false),
                new TestData(invalid, false, true),
                new TestData(incomplete, false, false)
                );
    }

    record TestData(SmallBoard smallBoard, boolean areAllFieldsFilled, boolean hasDuplication) {

    }
}