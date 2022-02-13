package br.com.letscode.desafio.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WinningMovieChosenValidator implements ConstraintValidator<WinningMovieChosen, Short> {

    @Override
    public boolean isValid(Short winningMovieChosen, ConstraintValidatorContext constraintValidatorContext) {
        return (winningMovieChosen == 1 || winningMovieChosen == 2);
    }

}