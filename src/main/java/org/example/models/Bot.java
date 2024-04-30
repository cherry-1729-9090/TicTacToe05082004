package org.example.models;

import java.util.List;

public class Bot extends Player {
    private BotDifficultyLevel difficultyLevel;

    public Bot(String playerName, Symbol playerSymbol, PlayerType playerType, BotDifficultyLevel difficultyLevel) {
        super(playerName, playerSymbol, playerType);
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board gameBoard) {
        // Find the first empty cell and make the move there.
        for (List<Cell> row : gameBoard.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}
