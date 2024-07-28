package com.example.GameLibrary.controller;

import com.example.GameLibrary.dtos.Requests.Games.GameAddRequestDto;
import com.example.GameLibrary.dtos.Requests.Games.GameUpdateRequestDto;
import com.example.GameLibrary.dtos.Responses.games.GameResponseDto;
import com.example.GameLibrary.entities.Game;
import com.example.GameLibrary.service.games.GameService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/games/")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody @Valid GameAddRequestDto dto){
        String result= gameService.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> delete(@RequestParam Long id){
        String result = gameService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("getbyid")
    public ResponseEntity<GameResponseDto> getById(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.getById(id));
    }

    @GetMapping("getall")
    public ResponseEntity<List<GameResponseDto>> getAllGames(){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.getAllGames());
    }

    @GetMapping("getbygenreid")
    public ResponseEntity<List<GameResponseDto>> getByGenreId(@RequestParam Long genreId){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.getAllByGenreId(genreId));
    }

    @DeleteMapping("clear")
    public ResponseEntity<String> clear() {
        return ResponseEntity.status(HttpStatus.OK).body(gameService.deleteAll());
    }

    @PutMapping("update")
    public ResponseEntity<String> update(@RequestBody GameUpdateRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(gameService.update(dto));
    }



}
