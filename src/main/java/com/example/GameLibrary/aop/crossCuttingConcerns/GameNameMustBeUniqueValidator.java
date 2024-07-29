package com.example.GameLibrary.aop.crossCuttingConcerns;

import com.example.GameLibrary.aop.annotations.GameNameMustBeUnique;
import com.example.GameLibrary.dataAccess.GameRepo;
import com.example.GameLibrary.entities.Game;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class GameNameMustBeUniqueValidator implements ConstraintValidator<GameNameMustBeUnique,String> {
    private final GameRepo repo;

    public GameNameMustBeUniqueValidator(GameRepo repo) {
        this.repo = repo;
    }

    @Override
    public void initialize(GameNameMustBeUnique constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Game> g = repo.findByName(s);
        return g.isEmpty();
    }
}
