package com.example.GameLibrary.service.games;

import com.example.GameLibrary.Exceptions.GameNotFoundException;
import com.example.GameLibrary.Exceptions.GenreNotFoundException;
import com.example.GameLibrary.Exceptions.NotFoundException;
import com.example.GameLibrary.dataAccess.GameRepo;
import com.example.GameLibrary.dataAccess.GenreRepo;
import com.example.GameLibrary.dtos.Requests.Games.GameAddRequestDto;
import com.example.GameLibrary.dtos.Requests.Games.GameUpdateRequestDto;
import com.example.GameLibrary.dtos.Responses.games.GameResponseDto;
import com.example.GameLibrary.entities.Game;
import com.example.GameLibrary.entities.Genre;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@NoArgsConstructor
public class GameMapper {


    protected Game convertDtoToEntity(GameRepo gameRepo, GameUpdateRequestDto dto){
        Game g = gameRepo.findById(dto.id()).orElseThrow(()->new GameNotFoundException(dto.id()));

        Genre genre = new Genre();
        genre.setId(dto.genreId());

        g.setName(dto.name());
        g.setPlayers(dto.players());
        g.setPrice(dto.price());
        g.setOverview(dto.overview());
        g.setInputDevices(dto.inputDevices());
        g.setReleaseDate(dto.releaseDate());
        g.setGenre(genre);

        return g;
    }

    protected Game convertDtoToEntity(Genre genre,GameAddRequestDto dto){
        Game g = new Game();
        g.setName(dto.name());
        g.setPlayers(dto.players());
        g.setPrice(dto.price());
        g.setGenre(genre);
        g.setOverview(dto.overview());
        g.setInputDevices(dto.inputDevices());
        g.setReleaseDate(new Date());

        return g;
    }

    protected Game handleAddGame(GenreRepo genreRepo ,GameAddRequestDto dto){
        Genre genre = genreRepo.findById(dto.genreId()).orElseThrow(()->new GenreNotFoundException(dto.genreId()));
        Game g = convertDtoToEntity(genre,dto);
        genre.setGameCount(genre.getGameCount()+1);
        genreRepo.save(genre);

        return g;
    }
    protected GameResponseDto convertEntityToDto(Game g){
        return new GameResponseDto(g.getId(),g.getName(),g.getGenre().getName(),g.getOverview(),g.getPrice(),g.getInputDevices(),g.getPlayers(),g.getReleaseDate());
    }
}
