package com.example.GameLibrary.Exceptions;

public class NotFoundException extends RuntimeException{
    private Long id;
    public NotFoundException(Long id){
        super("There is no game or genre with the id " + id);
        this.id = id;
    }

    protected Long getId(){
        return this.id;
    }
}