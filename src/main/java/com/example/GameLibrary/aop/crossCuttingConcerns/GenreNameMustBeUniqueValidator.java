package com.example.GameLibrary.aop.crossCuttingConcerns;

import com.example.GameLibrary.aop.annotations.GenreNameMustBeUnique;
import com.example.GameLibrary.dataAccess.GenreRepo;
import com.example.GameLibrary.entities.Genre;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class GenreNameMustBeUniqueValidator implements ConstraintValidator<GenreNameMustBeUnique,String> {
    private final GenreRepo repo;

    public GenreNameMustBeUniqueValidator(GenreRepo repo) {
        this.repo = repo;
    }

    @Override
    public void initialize(GenreNameMustBeUnique constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Genre> g = repo.findByName(s);
        return g.isEmpty();

    }
}
