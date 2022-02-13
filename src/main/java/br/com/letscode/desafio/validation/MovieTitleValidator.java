package br.com.letscode.desafio.validation;

import br.com.letscode.desafio.domain.request.TopTrumpsRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MovieTitleValidator implements ConstraintValidator<MovieTitle, TopTrumpsRequest> {

    @Override
    public boolean isValid(TopTrumpsRequest topTrumpsRequest, ConstraintValidatorContext constraintValidatorContext) {
        return (!topTrumpsRequest.getMovieTitle1().trim().equalsIgnoreCase(topTrumpsRequest.getMovieTitle2().trim()));
    }

}