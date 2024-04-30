package org.example;

import org.example.controllers.GameController;
import org.example.exceptions.InvalidMoveException;
import org.example.models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        System.out.println("Hello world!");
        Scanner inputScanner = new Scanner(System.in); // Renamed variable 'scanner' to 'inputScanner'
        GameController gameController = new GameController();

        int gameDimension = 3; // Renamed variable 'dimension' to 'gameDimension'
        List<Player> gamePlayers = List.of(
                new Player("DeviCharan", new Symbol('X'), PlayerType.HUMAN),
                new Bot("ScalerSchoolOfTechnology", new Symbol('O'), PlayerType.BOT, BotDifficultyLevel.EASY)
        );

        Game currentGame = gameController.startGame(gameDimension, gamePlayers); // Renamed variable 'game' to 'currentGame'

        while (currentGame.getGameState().equals(GameState.IN_PROGRESS)) {
            // Print the game board
            gameController.printBoard(currentGame);

            // Player's turn
            gameController.makeMove(currentGame);
        }

        if (!gameController.checkState(currentGame).equals(GameState.ENDED)) {
            currentGame.setGameState(GameState.DRAW);
            System.out.println("Game DRAW");
        } else {
            gameController.printBoard(currentGame);
            System.out.println("Player " + gameController.getWinner(currentGame).getName() + " is the winner");
        }
    }
}
