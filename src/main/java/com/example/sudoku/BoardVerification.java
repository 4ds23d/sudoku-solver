package com.example.sudoku;

interface BoardVerification {

    default boolean isComplete() {
        return areAllFieldsFilled() && noDuplication();
    }

    boolean areAllFieldsFilled();

    boolean noDuplication();

    default boolean hasDuplication() {
        return !noDuplication();
    }
}
