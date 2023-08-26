package org.oandx.service;

import org.junit.jupiter.api.Test;
import org.oandx.rest.response.BoardResponse;

import static org.junit.jupiter.api.Assertions.*;

class BoardServiceImplTest {

    BoardService boardService = new BoardServiceImpl();

    @Test
    public void testThatAnInvalidIdWillReturnAnEmptyOptional(){
        assertEquals(boardService.retrieveBoard(101).isEmpty(), true);
    }

    @Test
    public void testThatWhenABoardIsCreatedItCanBeRetrieved(){
        BoardResponse board = boardService.createBoard();
        assertNotNull(boardService.retrieveBoard(board.id()).get());
    }

}