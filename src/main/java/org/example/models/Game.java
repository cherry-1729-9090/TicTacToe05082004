package org.example.models;

import org.example.exceptions.InvalidMoveException;
import org.example.strategies.WinningAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board gameBoard;
    private List<Player> gamePlayers;
    private List<Move> gameMoves;
    private GameState gameStatus;
    private Player gameWinner;
    private int currentPlayerIndex;
    private WinningAlgorithm winningAlgorithm;

    public Game(int dimension, List<Player> players) {
        this.gameBoard = new Board(dimension);
        this.gamePlayers = players;
        this.gameMoves = new ArrayList<>();
        this.gameStatus = GameState.IN_PROGRESS;
        this.gameWinner = null;
        this.currentPlayerIndex = 0;
        this.winningAlgorithm = new WinningAlgorithm();
    }

    public Board getBoard() {
        return gameBoard;
    }

    public void setBoard(Board board) {
        this.gameBoard = board;
    }

    public List<Player> getPlayers() {
        return gamePlayers;
    }

    public void setPlayers(List<Player> players) {
        this.gamePlayers = players;
    }

    public List<Move> getMoves() {
        return gameMoves;
    }

    public void setMoves(List<Move> moves) {
        this.gameMoves = moves;
    }

    public GameState getGameState() {
        return gameStatus;
    }

    public void setGameState(GameState gameState) {
        this.gameStatus = gameState;
    }

    public Player getWinner() {
        return gameWinner;
    }

    public void setWinner(Player winner) {
        this.gameWinner = winner;
    }

    public int getNextPlayerMoveIndex() {
        return currentPlayerIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.currentPlayerIndex = nextPlayerMoveIndex;
    }

    public void printBoard() {
        this.gameBoard.printBoard();
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= gameBoard.getSize() || col < 0 || col >= gameBoard.getSize()) {
            return false;
        }

        return gameBoard.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = gamePlayers.get(currentPlayerIndex);

        System.out.println("It is " + currentPlayer.getName() + "'s move.");

        Move move = currentPlayer.makeMove(gameBoard);

        if (!validateMove(move)) {
            throw new InvalidMoveException("Invalid move made by " + currentPlayer.getName());
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = gameBoard.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(CellState.FILLED);

        Move finalMove = new Move(cellToChange, currentPlayer);
        gameMoves.add(finalMove);
        currentPlayerIndex = (currentPlayerIndex + 1) % gamePlayers.size();

        if (winningAlgorithm.checkWinner(gameBoard, finalMove)) {
            gameStatus = GameState.ENDED;
            gameWinner = currentPlayer;
        }
    }
}
