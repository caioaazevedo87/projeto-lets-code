package br.com.letscode.desafio.domain.response.access;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessResponse {

    @JsonProperty("usuário")
    private String usuario;

    @JsonProperty("mensagem")
    private String mensagem;

    public AccessResponse(String usuario, String mensagem) {
        this.usuario = usuario;
        this.mensagem = mensagem;
    }
}



