package com.example.GameLibrary.Exceptions;

public class GenreNotFoundException extends NotFoundException{
    public GenreNotFoundException(Long id) {
        super(id);
    }

    @Override
    public String getMessage() {
        return "There is no genre with the id " + super.getId() ;
    }
}
