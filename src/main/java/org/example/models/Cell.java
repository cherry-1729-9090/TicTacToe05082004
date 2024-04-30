package org.example.models;

public class Cell {
    private int rowIndex;
    private int colIndex;
    private CellState state;
    private Player occupyingPlayer;

    public Cell(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.state = CellState.EMPTY;
    }

    public int getRow() {
        return rowIndex;
    }

    public void setRow(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getCol() {
        return colIndex;
    }

    public void setCol(int colIndex) {
        this.colIndex = colIndex;
    }

    public CellState getCellState() {
        return state;
    }

    public void setCellState(CellState state) {
        this.state = state;
    }

    public Player getPlayer() {
        return occupyingPlayer;
    }

    public void setPlayer(Player occupyingPlayer) {
        this.occupyingPlayer = occupyingPlayer;
    }
}
