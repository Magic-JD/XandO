package org.oandx.validation.celltaken;

import org.oandx.data.Board;
import org.oandx.validation.ValidationIssue;
import org.oandx.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CellTakenValidator implements Validator {

    @Override
    public Optional<ValidationIssue> validate(Board board, int x, int y, int character) {
        if(board.getAt(x, y) != 0){
            return Optional.of(new CellTakenValidationIssue());
        }
        return Optional.empty();
    }
}
