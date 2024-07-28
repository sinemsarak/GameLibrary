package com.example.GameLibrary.dtos.Responses.genres;

import com.example.GameLibrary.dtos.Responses.games.GameResponseDto;
import com.example.GameLibrary.entities.Game;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


public record GenreResponseDto(
        Long id,
        String name,
        int gameCount
) {
    public GenreResponseDto(Long id, String name, int gameCount) {
        this.id = id;
        this.name = name;
        this.gameCount = gameCount;
    }
}
