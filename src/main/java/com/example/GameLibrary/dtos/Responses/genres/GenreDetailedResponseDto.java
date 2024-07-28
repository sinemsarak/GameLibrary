package com.example.GameLibrary.dtos.Responses.genres;

import com.example.GameLibrary.dtos.Responses.games.GameAbstractInfoDto;
import com.example.GameLibrary.dtos.Responses.games.GameResponseDto;

import java.util.List;
public record GenreDetailedResponseDto(Long id, List<GameAbstractInfoDto> gameList, String name, int gameCount) {
}
