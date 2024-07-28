package com.example.GameLibrary.service.genres;

import com.example.GameLibrary.dtos.Requests.Genres.GenreAddRequestDto;
import com.example.GameLibrary.dtos.Requests.Genres.GenreUpdateRequestDto;
import com.example.GameLibrary.dtos.Responses.genres.GenreDetailedResponseDto;
import com.example.GameLibrary.dtos.Responses.genres.GenreResponseDto;

import java.util.List;

public sealed interface GenreService permits GenreManager {

    String delete(Long id);
    List<GenreResponseDto> getAllGenres();
    String add(GenreAddRequestDto dto);
    String update(GenreUpdateRequestDto dto);
    String deleteAll();
    GenreResponseDto getByID(Long id);
    GenreDetailedResponseDto getDetailedByID(Long id);


}
