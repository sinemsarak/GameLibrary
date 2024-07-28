package com.example.GameLibrary.Exceptions;

public class GameNotFoundException extends NotFoundException{
    public GameNotFoundException(Long id) {
        super(id);
    }

    @Override
    public String getMessage() {
        return "There is no game with the id " + super.getId() ;
    }
}
