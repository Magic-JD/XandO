package org.oandx.validation.wrongturn;

import org.oandx.data.Board;
import org.oandx.validation.ValidationIssue;
import org.oandx.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WrongTurnValidator implements Validator {

    @Override
    public Optional<ValidationIssue> validate(Board board, int x, int y, int character) {
        int countX = numberOfCharacterOnBoard(board, 1);
        int countY = numberOfCharacterOnBoard(board, 2);
        if(character == 1){
            if(countX > countY){
                return Optional.of(new WrongTurnValidationIssue());
            }
            return Optional.empty();
        } else {
            if(countY >= countX){
                return Optional.of(new WrongTurnValidationIssue());
            }
            return Optional.empty();
        }
    }

    private int numberOfCharacterOnBoard(Board board, int character){
        int count = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if(board.getAt(x,y) == character){
                    count++;
                }
            }
        }
        return count;
    }
}
