package br.com.letscode.desafio.domain.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ImdbParametersRequest {

    private String i;
    private String apikey;

}
