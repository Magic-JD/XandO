package org.oandx.rest;

import org.oandx.data.Board;
import org.oandx.rest.request.ChoiceRequest;
import org.oandx.rest.response.BoardResponse;
import org.oandx.service.BoardService;
import org.oandx.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputControllerImpl implements InputController{

    @Autowired GameService gameService;
    BoardService boardService;

    public InputControllerImpl(@Autowired BoardService boardService){
        this.boardService = boardService;
    }

    @Override
    public ResponseEntity inputChoice(ChoiceRequest choice) {
        return boardService.retrieveBoard(choice.getBoardId())
                .map(board -> wrapGameUpdate(board, choice))
                .orElse(ResponseEntity.noContent().build());
    }

    private ResponseEntity wrapGameUpdate(Board board, ChoiceRequest choiceRequest) {
        return gameService.updateBoard(board, choiceRequest.getX(), choiceRequest.getY(), choiceRequest.getCharacter())
                .map(validationIssue -> ResponseEntity.badRequest().body(validationIssue.getIssueDescription()))
                .orElse(ResponseEntity.ok(hasWon(board)));
    }

    private String hasWon(Board board){
        if(gameService.isSolved(board)){
            return "YES";
        } else {
            return "NO";
        }
    }

    @Override
    public ResponseEntity<BoardResponse> createBoard() {
        return ResponseEntity.ok(boardService.createBoard());
    }

    @Override
    public ResponseEntity<BoardResponse> retrieveBoard(Integer id) {
        return boardService.retrieveBoard(id)
                .map(board -> new BoardResponse(id, board.getGrid()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}
