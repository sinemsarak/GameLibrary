package com.example.GameLibrary.dtos.Requests.Games;

import com.example.GameLibrary.enums.InputDevice;
import com.example.GameLibrary.enums.Players;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public record GameUpdateRequestDto(
        @NotNull(message= "Please enter an id to update")
        Long id,
        @Size(min = 2, message = "Game name must be more than 2 characters")
        String name,
        @Size(min = 5, max = 200, message = "Overview must be more than 5 and less than 200 characters")
        String overview,

        float price,
        Long genreId,
        InputDevice inputDevices,
        Players players,
        Date releaseDate


) {
}
