package org.example.models;

public class Move {
    private Cell moveCell;
    private Player movePlayer;

    public Move(Cell cell, Player player) {
        this.moveCell = cell;
        this.movePlayer = player;
    }

    public Cell getCell() {
        return moveCell;
    }

    public void setCell(Cell cell) {
        this.moveCell = cell;
    }

    public Player getPlayer() {
        return movePlayer;
    }

    public void setPlayer(Player player) {
        this.movePlayer = player;
    }
}
