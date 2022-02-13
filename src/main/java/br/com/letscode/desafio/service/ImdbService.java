package br.com.letscode.desafio.service;

import br.com.letscode.desafio.domain.model.ImdbParameter;
import br.com.letscode.desafio.domain.request.ImdbParametersRequest;
import br.com.letscode.desafio.domain.request.TopTrumpsRequest;
import br.com.letscode.desafio.domain.response.ImdbResponse;
import br.com.letscode.desafio.exception.BusinessException;
import br.com.letscode.desafio.exception.NotFoundException;
import br.com.letscode.desafio.repository.ImdbParametersRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Locale;

@Service
public class ImdbService {

    @Autowired
    private ImdbParametersRepository imdbParametersRepository;

    public ImdbParametersRequest getImdbParametersRequest() {
        return ImdbParametersRequest.builder()
                .apikey(getImdbParameterByKey("apikey").getValue())
                .i(getImdbParameterByKey("i").getValue())
                .build();
    }

    public String getTopTrumpsResult(TopTrumpsRequest topTrumpsRequest, ImdbResponse movie1, ImdbResponse movie2) {
        Short winningMovieChosen = topTrumpsRequest.getChooseWinner1Or2();
        if (doTopTrumps(movie1, movie2, winningMovieChosen)) {
            return "Marcou 1 ponto!";
        } else {
            return "Respota errada! Nenhum ponto marcado.";
        }
    }

    public boolean doTopTrumps(ImdbResponse movie1, ImdbResponse movie2, Short winningMovieChosen) {
        double movie1Score = calculateScore(movie1);
        double movie2Score = calculateScore(movie2);

        switch (winningMovieChosen) {
            case 1:
                return movie1Score > movie2Score;
            case 2:
                return movie2Score > movie1Score;
            default:
                throw new BusinessException("O filme escolhido está inválido");
        }
    }

    private ImdbParameter getImdbParameterByKey(String key) {
        return imdbParametersRepository.findByKey(key).orElseThrow(
                () -> new NotFoundException("Key não encontrada na base de dados!"));
    }

    @SneakyThrows
    private double calculateScore(ImdbResponse imdbResponse) {
        double rating = Double.parseDouble(imdbResponse.getImdbRating());
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        long votes = format.parse(imdbResponse.getImdbVotes()).longValue();
        return rating * votes;
    }

}
