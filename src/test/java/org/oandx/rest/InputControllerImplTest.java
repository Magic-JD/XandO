package org.oandx.rest;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.oandx.data.Board;
import org.oandx.service.BoardService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class InputControllerImplTest {

    BoardService boardService = Mockito.mock(BoardService.class);
    InputControllerImpl SUT = new InputControllerImpl(boardService);

    @Test
    void retrieveBoard() {
        when(boardService.retrieveBoard(anyInt())).thenReturn(Optional.of(new Board()));
        assertNotNull(SUT.retrieveBoard(101).getBody().grid());
    }
}