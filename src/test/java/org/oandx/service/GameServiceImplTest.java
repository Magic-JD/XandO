package org.oandx.service;

import org.junit.jupiter.api.Test;
import org.oandx.data.Board;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceImplTest {

    private GameServiceImpl gameServiceImpl = new GameServiceImpl();

    @Test
    void testNewBoardIsNotSolved() {
        assertFalse(gameServiceImpl.isSolved(new Board()));
    }

    @Test
    void testBoardSolvedVerticallyIsSolved() {
        Board board = new Board();
        board.setAt(0, 0, 1);
        board.setAt(0, 1, 1);
        board.setAt(0, 2, 1);
        assertTrue(gameServiceImpl.isSolved(board));
    }

    @Test
    void testBoardSolvedHorizontallyIsSolved() {
        Board board = new Board();
        board.setAt(0, 0, 1);
        board.setAt(1, 0, 1);
        board.setAt(2, 0, 1);
        assertTrue(gameServiceImpl.isSolved(board));
    }

    @Test
    void testBoardSolvedDiagonallyIsSolved() {
        Board board = new Board();
        board.setAt(0, 0, 1);
        board.setAt(1, 1, 1);
        board.setAt(2, 2, 1);
        assertTrue(gameServiceImpl.isSolved(board));
    }
}