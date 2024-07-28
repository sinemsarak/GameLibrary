package com.example.GameLibrary.service.genres;

import com.example.GameLibrary.Exceptions.GenreNotFoundException;
import com.example.GameLibrary.dataAccess.GameRepo;
import com.example.GameLibrary.dataAccess.GenreRepo;
import com.example.GameLibrary.dtos.Requests.Genres.GenreAddRequestDto;
import com.example.GameLibrary.dtos.Requests.Genres.GenreUpdateRequestDto;
import com.example.GameLibrary.dtos.Responses.games.GameAbstractInfoDto;
import com.example.GameLibrary.dtos.Responses.games.GameResponseDto;
import com.example.GameLibrary.dtos.Responses.genres.GenreDetailedResponseDto;
import com.example.GameLibrary.dtos.Responses.genres.GenreResponseDto;
import com.example.GameLibrary.entities.Game;
import com.example.GameLibrary.entities.Genre;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@Component
public class GenreMapper {


    protected Genre convertDtoToGenre(GenreAddRequestDto dto){
        Genre g = new Genre();
        g.setName(dto.name());
        return g;
    }

    protected Genre convertDtoToGenre(GenreRepo genreRepo, GenreUpdateRequestDto dto){
        Genre g = genreRepo.findById(dto.id()).orElseThrow(()->new GenreNotFoundException(dto.id()));
        g.setName(dto.name());
        return g;
    }

    protected GenreResponseDto convertGenreToDto(Genre g){
        return new GenreResponseDto(g.getId(),g.getName(),g.getGameCount());
    }

    protected GenreDetailedResponseDto convertDetailedGenreToDto(GameRepo gameRepo,Genre g) {
        List<GameAbstractInfoDto> gameList = gameRepo.findAllBygenreId(g.getId()).stream().map(this::convertToAbstractInfoDto).toList() ;
        return new GenreDetailedResponseDto(g.getId(),gameList,g.getName(),g.getGameCount());
    }

    private GameAbstractInfoDto convertToAbstractInfoDto(Game g){
        return new GameAbstractInfoDto(g.getId(),g.getName(),g.getOverview());
    }
}
