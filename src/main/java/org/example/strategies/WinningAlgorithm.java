package org.example.strategies;

import org.example.models.Board;
import org.example.models.Move;

import java.util.HashMap;

public class WinningAlgorithm {
    // row number -> hashMap for that row
    private HashMap<Integer, HashMap<Character, Integer>> rowCharacterCountMap = new HashMap<>();
    private HashMap<Integer, HashMap<Character, Integer>> colCharacterCountMap = new HashMap<>();
    private HashMap<Character, Integer> leftDiagonalCharacterCountMap = new HashMap<>();
    private HashMap<Character, Integer> rightDiagonalCharacterCountMap = new HashMap<>();

    public boolean checkWinner(Board gameBoard, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character symbolChar = move.getPlayer().getSymbol().getSymbolChar();

        // Row
        if (!rowCharacterCountMap.containsKey(row)) {
            rowCharacterCountMap.put(row, new HashMap<>());
        }
        HashMap<Character, Integer> currRowMap = rowCharacterCountMap.get(row);

        if (!currRowMap.containsKey(symbolChar)) {
            currRowMap.put(symbolChar, 1);
        } else {
            currRowMap.put(symbolChar, currRowMap.get(symbolChar) + 1);
        }

        if (currRowMap.get(symbolChar) == gameBoard.getSize()) {
            return true;
        }

        // Column
        if (!colCharacterCountMap.containsKey(col)) {
            colCharacterCountMap.put(col, new HashMap<>());
        }
        HashMap<Character, Integer> currColMap = colCharacterCountMap.get(col);

        if (!currColMap.containsKey(symbolChar)) {
            currColMap.put(symbolChar, 1);
        } else {
            currColMap.put(symbolChar, currColMap.get(symbolChar) + 1);
        }

        if (currColMap.get(symbolChar) == gameBoard.getSize()) {
            return true;
        }

        // Left Diagonal
        if (row == col) {
            if (!leftDiagonalCharacterCountMap.containsKey(symbolChar)) {
                leftDiagonalCharacterCountMap.put(symbolChar, 1);
            } else {
                leftDiagonalCharacterCountMap.put(symbolChar, leftDiagonalCharacterCountMap.get(symbolChar) + 1);
            }

            if (leftDiagonalCharacterCountMap.get(symbolChar) == gameBoard.getSize()) {
                return true;
            }
        }

        // Right Diagonal
        if (row + col == gameBoard.getSize() - 1) {
            if (!rightDiagonalCharacterCountMap.containsKey(symbolChar)) {
                rightDiagonalCharacterCountMap.put(symbolChar, 1);
            } else {
                rightDiagonalCharacterCountMap.put(symbolChar, rightDiagonalCharacterCountMap.get(symbolChar) + 1);
            }

            if (rightDiagonalCharacterCountMap.get(symbolChar) == gameBoard.getSize()) {
                return true;
            }
        }

        return false;
    }
}
