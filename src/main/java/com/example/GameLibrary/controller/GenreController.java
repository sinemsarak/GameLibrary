package com.example.GameLibrary.controller;


import com.example.GameLibrary.dtos.Requests.Genres.GenreAddRequestDto;
import com.example.GameLibrary.dtos.Requests.Genres.GenreUpdateRequestDto;
import com.example.GameLibrary.dtos.Responses.genres.GenreResponseDto;
import com.example.GameLibrary.service.genres.GenreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/genres/")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService){
        this.genreService = genreService;
    }
    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody @Valid GenreAddRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.genreService.add(dto));
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> delete(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(genreService.delete(id));
    }

    @DeleteMapping("clear")
    public ResponseEntity<String> deleteAll(){
        return ResponseEntity.status(HttpStatus.OK).body(genreService.deleteAll());
    }

    @PostMapping("update")
    public ResponseEntity<String> update(@RequestBody @Valid GenreUpdateRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(genreService.update(dto));
    }

    @GetMapping("getbyid")
    public ResponseEntity<GenreResponseDto> getById(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(genreService.getByID(id));
    }

    @GetMapping("getall")
    public ResponseEntity<List<GenreResponseDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(genreService.getAllGenres());
    }

}
