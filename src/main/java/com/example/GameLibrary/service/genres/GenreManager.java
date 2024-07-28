package com.example.GameLibrary.service.genres;

import com.example.GameLibrary.Exceptions.GenreNotFoundException;
import com.example.GameLibrary.Exceptions.NotFoundException;
import com.example.GameLibrary.dataAccess.GameRepo;
import com.example.GameLibrary.dataAccess.GenreRepo;
import com.example.GameLibrary.dtos.Requests.Genres.GenreAddRequestDto;
import com.example.GameLibrary.dtos.Requests.Genres.GenreUpdateRequestDto;
import com.example.GameLibrary.dtos.Responses.genres.GenreDetailedResponseDto;
import com.example.GameLibrary.dtos.Responses.genres.GenreResponseDto;
import com.example.GameLibrary.entities.Genre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public final class GenreManager implements GenreService {

    private final GenreRepo genreRepo;
    private final GameRepo gameRepo;
    private final GenreMapper mapper;

    public GenreManager(GenreRepo genreRepo, GameRepo gameRepo, GenreMapper mapper) {
        this.genreRepo = genreRepo;
        this.gameRepo = gameRepo;
        this.mapper = mapper;
    }

    @Override
    public String delete(Long id) {
        Genre g = this.genreRepo.findById(id).orElseThrow(() -> new GenreNotFoundException(id));
        this.genreRepo.delete(g);
        return g.getName() + " has been successfully deleted";
    }

    @Override
    public List<GenreResponseDto> getAllGenres() {

        return this.genreRepo.findAll().stream().map(mapper::convertGenreToDto).toList();
    }

    @Override
    public String add(GenreAddRequestDto dto) {
        Genre g = mapper.convertDtoToGenre(dto);
        this.genreRepo.save(g);
        return g.getName() + " successfully added.";
    }

    @Override
    public String update(GenreUpdateRequestDto dto) {
        Genre g = mapper.convertDtoToGenre(this.genreRepo,dto);
        this.genreRepo.save(g);
        return g.getName() + " successfully updated.";
    }

    @Override
    public String deleteAll() {
        this.genreRepo.deleteAll();
        return "Genre list successfully cleared";
    }

    @Override
    public GenreResponseDto getByID(Long id) {
        Genre g = this.genreRepo.findById(id).orElseThrow(() -> new GenreNotFoundException(id));
        return mapper.convertGenreToDto(g);
    }

    @Override
    public GenreDetailedResponseDto getDetailedByID(Long id) {
        Genre g = this.genreRepo.findById(id).orElseThrow(() -> new GenreNotFoundException(id));
        return mapper.convertDetailedGenreToDto(gameRepo,g);
    }

}
