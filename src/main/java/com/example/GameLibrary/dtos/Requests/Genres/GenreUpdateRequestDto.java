package com.example.GameLibrary.dtos.Requests.Genres;

import com.example.GameLibrary.aop.annotations.GenreNameMustBeUnique;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record GenreUpdateRequestDto (
        @NotNull(message= "Please enter an id to update")
        Long id,
        @Size(min = 2, message = "Genre name must be more than 2 characters")
        @GenreNameMustBeUnique
        String name){
}
