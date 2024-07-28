package com.example.GameLibrary.service.games;

import com.example.GameLibrary.Exceptions.GameNotFoundException;
import com.example.GameLibrary.Exceptions.GenreNotFoundException;
import com.example.GameLibrary.Exceptions.NotFoundException;
import com.example.GameLibrary.dataAccess.GenreRepo;
import com.example.GameLibrary.dtos.Requests.Games.GameUpdateRequestDto;
import com.example.GameLibrary.dtos.Responses.games.GameResponseDto;
import com.example.GameLibrary.entities.Game;
import com.example.GameLibrary.dataAccess.GameRepo;
import com.example.GameLibrary.dtos.Requests.Games.GameAddRequestDto;
import com.example.GameLibrary.entities.Genre;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public final class GameManager implements GameService {

    private final GameRepo gameRepo;
    private final GameMapper mapper;
    private final GenreRepo genreRepo;

    public GameManager(GameRepo gameRepo, GameMapper mapper, GenreRepo genreRepo) {
        this.gameRepo = gameRepo;
        this.mapper = mapper;
        this.genreRepo = genreRepo;
    }

    @Override
    public List<GameResponseDto> getAllByGenreId(Long genreId) {
        return this.gameRepo.findAllBygenreId(genreId).stream().map(mapper::convertEntityToDto).toList();
    }

    @Override
    public String add(GameAddRequestDto dto) {
        Game g = mapper.handleAddGame(this.genreRepo,dto);
        this.gameRepo.save(g);
        return g.getName() + " successfully added";
    }

    @Override
    public String delete(Long id) {
        Game g = this.gameRepo.findById(id).orElseThrow(()-> new GameNotFoundException(id));
        Genre genre = this.genreRepo.findById(g.getGenre().getId()).orElseThrow(()-> new GenreNotFoundException(id));;
        genre.setGameCount(genre.getGameCount()-1);
        genreRepo.save(genre);
        this.gameRepo.delete(g);

        return g.getName() + " successfully deleted";
    }

    @Override
    public GameResponseDto getById(Long id) {
       Game g = this.gameRepo.findById(id).orElseThrow(()-> new GameNotFoundException(id));
       return mapper.convertEntityToDto(g);
    }

    @Override
    public List<GameResponseDto> getAllGames() {
        return this.gameRepo.findAll().stream().map(mapper::convertEntityToDto).toList();
    }

    @Override
    public String deleteAll() {
        this.gameRepo.deleteAll();
        return "Game list successfully cleared";
    }

    @Override
    public String update(GameUpdateRequestDto dto) {
        this.gameRepo.save(mapper.convertDtoToEntity(this.gameRepo,dto));
        return dto.name() + " successfully updated";
    }





}
