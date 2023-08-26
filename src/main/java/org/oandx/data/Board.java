package org.oandx.data;

public class Board {

    private int[][] grid;

    public Board(){
        grid = new int[3][3];
    }

    public int getAt(int x, int y){
        return grid[x][y];
    }

    public void setAt(int x, int y, int value){
        grid[x][y] = value;
    }

    public int[][] getGrid() {
        return grid.clone();
    }
}

