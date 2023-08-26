package org.oandx.rest;

import org.oandx.data.Board;
import org.oandx.rest.request.ChoiceRequest;
import org.oandx.rest.response.BoardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/xando")
public interface InputController {

    @PostMapping("/choice")
    ResponseEntity inputChoice(@RequestBody ChoiceRequest choice);

    @GetMapping("/board/create")
    @ResponseBody
    ResponseEntity<BoardResponse> createBoard();

    @GetMapping("/board/retrieve/{id}")
    @ResponseBody
    ResponseEntity<BoardResponse> retrieveBoard(@PathVariable Integer id);
}
