package org.oandx.service;

import org.oandx.data.Board;
import org.oandx.validation.ValidationIssue;

import java.util.Optional;

public interface GameService {
    Optional<ValidationIssue> updateBoard(Board board, int x, int y, int character);

    boolean isSolved(Board board);
}
