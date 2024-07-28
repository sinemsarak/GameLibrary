package com.example.GameLibrary.service.games;

import com.example.GameLibrary.dtos.Requests.Games.GameUpdateRequestDto;
import com.example.GameLibrary.dtos.Responses.games.GameResponseDto;
import com.example.GameLibrary.entities.Game;
import com.example.GameLibrary.dtos.Requests.Games.GameAddRequestDto;

import java.util.List;

public sealed interface GameService permits GameManager {

    List<GameResponseDto> getAllByGenreId(Long genreId);

    String add(GameAddRequestDto game);
    String delete(Long id);
    GameResponseDto getById(Long id);
    List<GameResponseDto> getAllGames();
    String deleteAll();
    String update(GameUpdateRequestDto dto);
}
