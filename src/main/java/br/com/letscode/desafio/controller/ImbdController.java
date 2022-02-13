package br.com.letscode.desafio.controller;

import br.com.letscode.desafio.client.ImdbClient;
import br.com.letscode.desafio.domain.request.ImdbParametersRequest;
import br.com.letscode.desafio.domain.request.TopTrumpsRequest;
import br.com.letscode.desafio.domain.response.ImdbResponse;
import br.com.letscode.desafio.service.ImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/imdb")
@RestController
public class ImbdController {

    @Autowired
    private ImdbClient imdbClient;

    @Autowired
    private ImdbService imdbService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ImdbResponse getMovie(@RequestParam String movieTitle) {
        return imdbClient.getMovie(getImdbParametersRequest().getI(), getImdbParametersRequest().getApikey(), movieTitle);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/top-trumps")
    public String topTrumps(@RequestBody @Valid TopTrumpsRequest topTrumpsRequest) {
        ImdbResponse movie1 = imdbClient.getMovie(getImdbParametersRequest().getI(), getImdbParametersRequest().getApikey(), topTrumpsRequest.getMovieTitle1());
        ImdbResponse movie2 = imdbClient.getMovie(getImdbParametersRequest().getI(), getImdbParametersRequest().getApikey(), topTrumpsRequest.getMovieTitle2());
        return imdbService.getTopTrumpsResult(topTrumpsRequest, movie1, movie2);
    }


    private ImdbParametersRequest getImdbParametersRequest() {
        return imdbService.getImdbParametersRequest();
    }


}
