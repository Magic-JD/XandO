package org.oandx.service;

import org.oandx.data.Board;
import org.oandx.validation.ValidationIssue;
import org.oandx.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GameServiceImpl implements GameService {

    @Autowired private List<Validator> validators;

    @Override
    public Optional<ValidationIssue> updateBoard(Board board, int x, int y, int character) {
        Optional<ValidationIssue> validationIssue = runValidators(board, x, y, character);
        if(validationIssue.isEmpty()){
            board.setAt(x, y, character);
            return Optional.empty();
        }
        return validationIssue;

    }

    @Override
    public boolean isSolved(Board board) {
        boolean isSolved = false;
        Set<Integer> inLine = new HashSet<>();

        for (int i = 0; i < board.getGrid().length; i++) {
            inLine.add(board.getAt(0, i));
        }
        if(inLine.size() == 1 && inLine.contains(0) == false){
            isSolved = true;
        }
        inLine = new HashSet<>();
        for (int i = 0; i < board.getGrid().length; i++) {
            inLine.add(board.getAt(1, i));
        }
        if(inLine.size() == 1 && inLine.contains(0) == false){
            isSolved = true;
        }
        inLine = new HashSet<>();
        for (int i = 0; i < board.getGrid().length; i++) {
            inLine.add(board.getAt(2, i));
        }
        if(inLine.size() == 1 && inLine.contains(0) == false){
            isSolved = true;
        }
        inLine = new HashSet<>();
        for (int i = 0; i < board.getGrid().length; i++) {
            inLine.add(board.getAt(i, 0));
        }
        if(inLine.size() == 1 && inLine.contains(0) == false){
            isSolved = true;
        }
        inLine = new HashSet<>();
        for (int i = 0; i < board.getGrid().length; i++) {
            inLine.add(board.getAt(1, 1));
        }
        if(inLine.size() == 1 && inLine.contains(0) == false){
            isSolved = true;
        }
        inLine = new HashSet<>();
        for (int i = 0; i < board.getGrid().length; i++) {
            inLine.add(board.getAt(i, 2));
        }
        if(inLine.size() == 1 && inLine.contains(0) == false){
            isSolved = true;
        }
        inLine = new HashSet<>();
        for (int i = 0; i < board.getGrid().length; i++) {
            inLine.add(board.getAt(i, i));
        }
        if(inLine.size() == 1 && inLine.contains(0) == false){
            isSolved = true;
        }
        inLine = new HashSet<>();
        for (int i = board.getGrid().length-1; i >= 0; i--) {
            inLine.add(board.getAt(i, i));
        }
        if(inLine.size() == 1 && inLine.contains(0) == false){
            isSolved = true;
        }
        return isSolved;
    }

    private Optional<ValidationIssue> runValidators(Board board, int x, int y, int character) {
        return validators
                .stream()
                .map(validator -> validator.validate(board, x, y, character))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }
}
