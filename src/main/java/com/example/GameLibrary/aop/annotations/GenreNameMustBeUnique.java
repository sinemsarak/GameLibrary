package com.example.GameLibrary.aop.annotations;

import com.example.GameLibrary.aop.crossCuttingConcerns.GenreNameMustBeUniqueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD ,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {GenreNameMustBeUniqueValidator.class})
public @interface GenreNameMustBeUnique {
    String message() default "This genre already exists. Please enter another name";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
