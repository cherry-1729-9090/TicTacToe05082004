package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int boardSize;
    private List<List<Cell>> gameBoard;

    public int getSize() {
        return boardSize;
    }

    public void setSize(int size) {
        this.boardSize = size;
    }

    public List<List<Cell>> getBoard() {
        return gameBoard;
    }

    public void setBoard(List<List<Cell>> board) {
        this.gameBoard = board;
    }

    public Board(int size) {
        this.boardSize = size;
        gameBoard = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            gameBoard.add(new ArrayList<>());

            for (int j = 0; j < size; j++) {
                gameBoard.get(i).add(new Cell(i, j));
            }
        }
    }

    public void printBoard() {
        for (List<Cell> row : gameBoard) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    System.out.print("| -- |");
                } else {
                    System.out.print("| " + cell.getPlayer().getSymbol().getaChar() + " |");
                }
            }
            System.out.println();
        }
    }
}
