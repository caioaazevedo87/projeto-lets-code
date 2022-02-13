package br.com.letscode.desafio.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingResponse {

    @JsonProperty("Source") 
    public String source;

    @JsonProperty("Value") 
    public String value;

}



