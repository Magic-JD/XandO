package org.oandx.service;

import org.oandx.data.Board;
import org.oandx.rest.response.BoardResponse;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface BoardService {

    BoardResponse createBoard();

    Optional<Board> retrieveBoard(Integer id);
}
