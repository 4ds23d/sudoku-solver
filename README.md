# Sudoku Solver 🧩

A simple Sudoku solver using a brute-force algorithm. The solver is implemented in the test class:

📂 **`com.example.sudoku.SudokuSolverTest#solve`**

## Usage

You can use the Sudoku solver with the following example:

```java
var boardDef = """
500608902
600005040
100042067
800700403
406050091
003020050
900507204
207410605
040080009""";

var board = BoardFactory.of(boardDef);
var alg = new SudokuSolver();

// When
var solvedBoard = alg.solve(board);

```

This will take an unsolved Sudoku board as input and return the solved board.

Features
*	✅ Supports standard 9x9 Sudoku boards
*	✅ Uses brute-force algorithm to find a solution
*	✅ Simple API for easy integration

# Running the Tests

The solver is tested in SudokuSolverTest#solve, ensuring correctness. Run the test suite to verify functionality.
