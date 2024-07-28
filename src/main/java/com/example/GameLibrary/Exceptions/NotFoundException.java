package com.example.GameLibrary.Exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Long id){
        super("There is no game or genre with the id " + id);
    }
}