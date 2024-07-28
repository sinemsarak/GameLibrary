package com.example.GameLibrary.dtos.Responses.games;

import com.example.GameLibrary.enums.InputDevice;
import com.example.GameLibrary.enums.Players;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record GameResponseDto(
        Long id,
        String name,
        String genreName,
        String overview,
        float price,
        InputDevice inputDevices,
        Players players,
        Date releaseDate) {
    public GameResponseDto(Long id, String name,String genreName, String overview, float price, InputDevice inputDevices, Players players, Date releaseDate) {
        this.id = id;
        this.name = name;
        this.genreName = genreName;
        this.overview = overview;
        this.price = price;
        this.inputDevices = inputDevices;
        this.players = players;
        this.releaseDate = releaseDate;
    }
}
