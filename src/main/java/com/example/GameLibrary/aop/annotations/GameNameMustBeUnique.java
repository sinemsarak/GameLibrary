package com.example.GameLibrary.aop.annotations;

import com.example.GameLibrary.aop.crossCuttingConcerns.GameNameMustBeUniqueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD ,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {GameNameMustBeUniqueValidator.class})
public @interface GameNameMustBeUnique {
    String message() default "This game already exists. Please enter another name";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
