package org.example.models;

import java.util.Scanner;

public class Player {
    private String playerName;
    private Symbol playerSymbol;
    private PlayerType playerType;
    private static Scanner scanner = new Scanner(System.in);

    public Player(String playerName, Symbol playerSymbol, PlayerType playerType) {
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board gameBoard) {
        // Ask the user where they want to place the symbol.
        System.out.println("Please enter the row number where you want to make a move?");
        int row = scanner.nextInt();

        System.out.println("Please enter the column number where you want to make a move?");
        int col = scanner.nextInt();

        return new Move(new Cell(row, col), this);
    }

    public String getName() {
        return playerName;
    }

    public void setName(String playerName) {
        this.playerName = playerName;
    }

    public Symbol getSymbol() {
        return playerSymbol;
    }

    public void setSymbol(Symbol playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
