package com.example.GameLibrary.dtos.Requests.Genres;

import jakarta.validation.constraints.Size;

public record GenreAddRequestDto(
        @Size(min = 2, message = "Genre name must be more than 2 characters")
        String name
) {

}
