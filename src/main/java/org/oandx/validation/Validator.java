package org.oandx.validation;

import org.oandx.data.Board;

import java.util.Optional;

public interface Validator {
    public Optional<ValidationIssue> validate(Board board, int x, int y, int character);
}
