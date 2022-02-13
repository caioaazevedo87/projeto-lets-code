package br.com.letscode.desafio.client;

import br.com.letscode.desafio.domain.response.ImdbResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.imdb.name}", url = "${feign.imdb.url}")
public interface ImdbClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    ImdbResponse getMovie(@RequestParam String i, @RequestParam String apikey, @RequestParam String t);

}