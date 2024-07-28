package com.example.GameLibrary.dtos.Responses.games;

public record GameAbstractInfoDto (
    Long id,
    String name,
    String overview
    ){
    public GameAbstractInfoDto(Long id, String name, String overview) {
        this.id = id;
        this.name = name;
        this.overview = overview;
    }
}
