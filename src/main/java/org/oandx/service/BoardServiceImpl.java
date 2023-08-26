package org.oandx.service;

import org.oandx.data.Board;
import org.oandx.rest.response.BoardResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Optional;

@Component
public class BoardServiceImpl implements BoardService {

    private static final HashMap<Integer, Board> BOARD_STORAGE = new HashMap<>();
    private int id = 0;

    @Override
    public BoardResponse createBoard() {
        Board board = new Board();
        BOARD_STORAGE.put(id, board);
        return new BoardResponse(id++, board.getGrid());
    }

    @Override
    public Optional<Board> retrieveBoard(Integer id) {
        return Optional.ofNullable(BOARD_STORAGE.get(id));
    }
}
