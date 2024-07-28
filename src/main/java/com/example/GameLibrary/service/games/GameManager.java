package com.example.GameLibrary.service.games;

import com.example.GameLibrary.Exceptions.NotFoundException;
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

    public GameManager(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    @Override
    public List<GameResponseDto> getAllByGenreId(Long genreId) {
        return this.gameRepo.findAllBygenreId(genreId).stream().map(this::convertEntityToDto).toList();
    }

    @Override
    public String add(GameAddRequestDto dto) {
        Game g = convertDtoToEntity(dto);
        this.gameRepo.save(g);
        return g.getName() + " successfully added";
    }

    @Override
    public String delete(Long id) {
        Game g = this.gameRepo.findById(id).orElseThrow(()-> new NotFoundException(id));
        this.gameRepo.delete(g);
        return g.getName() + " successfully deleted";
    }

    @Override
    public GameResponseDto getById(Long id) {
       Game g = this.gameRepo.findById(id).orElseThrow(()-> new NotFoundException(id));
       return convertEntityToDto(g);
    }

    @Override
    public List<GameResponseDto> getAllGames() {
        return this.gameRepo.findAll().stream().map(this::convertEntityToDto).toList();
    }

    @Override
    public String deleteAll() {
        this.gameRepo.deleteAll();
        return "Game list successfully cleared";
    }

    @Override
    public String update(GameUpdateRequestDto dto) {
        Game g = this.gameRepo.findById(dto.id()).orElseThrow(()->new NotFoundException(dto.id()));
        g.setName(dto.name());
        g.setPlayers(dto.players());
        g.setPrice(dto.price());
        //g.setGenreId(dto.genreId());
        g.setOverview(dto.overview());
        g.setInputDevices(dto.inputDevices());
        g.setReleaseDate(dto.releaseDate());

        this.gameRepo.save(g);
        return g.getName() + " successfully updated";
    }



    private Game convertDtoToEntity(GameAddRequestDto dto){
        Game g = new Game();
        Genre genre = new Genre();
        genre.setId(dto.genreId());

        g.setName(dto.name());
        g.setPlayers(dto.players());
        g.setPrice(dto.price());
        g.setGenre(genre);
        g.setOverview(dto.overview());
        g.setInputDevices(dto.inputDevices());
        g.setReleaseDate(new Date());

        return g;
    }
    //todo update için de game şeyisisi yaz güncelle
    private GameResponseDto convertEntityToDto(Game g){
        return new GameResponseDto(g.getId(),g.getName(),g.getOverview(),g.getPrice(),g.getInputDevices(),g.getPlayers(),g.getReleaseDate());
    }


}
