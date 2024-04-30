package org.example.controllers;

import org.example.exceptions.InvalidMoveException;
import org.example.models.Game;
import org.example.models.GameState;
import org.example.models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int gameDimension, List<Player> gamePlayers) {
        // Validate if 2 players have the same symbol or not
        // If 2 players have the same symbol, throw some exception
        return new Game(gameDimension, gamePlayers);
    }

    public void makeMove(Game currentGame) throws InvalidMoveException {
        currentGame.makeMove();
    }

    public GameState checkState(Game currentGame) {
        return currentGame.getGameState();
    }

    public Player getWinner(Game currentGame) {
        return currentGame.getWinner();
    }

    public void printBoard(Game currentGame) {
        currentGame.printBoard();
    }
}
