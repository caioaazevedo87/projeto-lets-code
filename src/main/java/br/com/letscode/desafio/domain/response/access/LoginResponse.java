package br.com.letscode.desafio.domain.response.access;

public class LoginResponse extends AccessResponse {

    public LoginResponse(String usuario) {
        super(usuario, "Login realizado com sucesso!");
    }

}



