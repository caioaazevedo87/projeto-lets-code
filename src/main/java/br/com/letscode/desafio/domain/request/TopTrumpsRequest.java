package br.com.letscode.desafio.domain.request;

import br.com.letscode.desafio.validation.MovieTitle;
import br.com.letscode.desafio.validation.WinningMovieChosen;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MovieTitle(message = "{movie.title.not.valid}")
public class TopTrumpsRequest {

    @JsonProperty("movieTitle1")
    private String movieTitle1;

    @JsonProperty("movieTitle2")
    private String movieTitle2;

    @JsonProperty("chooseWinner1Or2")
    @WinningMovieChosen(message = "{winning.movie.choosen.not.valid}")
    private Short chooseWinner1Or2;

}
