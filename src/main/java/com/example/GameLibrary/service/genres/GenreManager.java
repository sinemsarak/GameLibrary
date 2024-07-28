package com.example.GameLibrary.service.genres;

import com.example.GameLibrary.Exceptions.NotFoundException;
import com.example.GameLibrary.dataAccess.GenreRepo;
import com.example.GameLibrary.dtos.Requests.Genres.GenreAddRequestDto;
import com.example.GameLibrary.dtos.Requests.Genres.GenreUpdateRequestDto;
import com.example.GameLibrary.dtos.Responses.genres.GenreResponseDto;
import com.example.GameLibrary.entities.Genre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public final class GenreManager implements GenreService {

    private final GenreRepo genreRepo;

    public GenreManager(GenreRepo genreRepo){
        this.genreRepo = genreRepo;
    }
    @Override
    public String delete(Long id) {
       Genre g = this.genreRepo.findById(id).orElseThrow(()->new NotFoundException(id));
       this.genreRepo.delete(g);
       return g.getName() + " has been successfully deleted";
    }

    @Override
    public List<GenreResponseDto> getAllGenres() {

        return this.genreRepo.findAll().stream().map(this::convertGenreToDto).toList();
    }

    @Override
    public String add(GenreAddRequestDto dto) {
        Genre g = convertDtoToGenre(dto);
        this.genreRepo.save(g);
        return g.getName() + " successfully added.";
    }

    @Override
    public String update(GenreUpdateRequestDto dto) {
        Genre g = convertDtoToGenre(dto);
        this.genreRepo.save(g);
        return g.getName() + " successfully updated.";
    }

    @Override
    public String deleteAll() {
        this.genreRepo.deleteAll();
        return "Genre list successfully cleared";
    }
    //todo genreyi silersem genrenin oyunlarına ne olur?
    //bağlı bir genreyi silemiyormuşuz internal server error veriyor, bunu handlemeyi deneyelim

    @Override
    public GenreResponseDto getByID(Long id) {
        Genre g = this.genreRepo.findById(id).orElseThrow(()->new NotFoundException(id));
        return convertGenreToDto(g);
    }

    private Genre convertDtoToGenre(GenreAddRequestDto dto){
        Genre g = new Genre();
        g.setName(dto.name());
        //g.setGameCount(0);
        //todo game count kısmına bi bakalım
        return g;
    }

    private Genre convertDtoToGenre(GenreUpdateRequestDto dto){
        Genre g = this.genreRepo.findById(dto.id()).orElseThrow(()->new NotFoundException(dto.id()));
        g.setName(dto.name());
        //g.setGameCount(0);
        return g;
    }

    private GenreResponseDto convertGenreToDto(Genre g){
        return new GenreResponseDto(g.getId(),g.getName(),g.getGameCount());
    }
}
