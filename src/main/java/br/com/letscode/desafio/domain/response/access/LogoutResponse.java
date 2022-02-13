package br.com.letscode.desafio.domain.response.access;

public class LogoutResponse extends AccessResponse {

    public LogoutResponse(String usuario) {
        super(usuario, "Logout realizado com sucesso!");
    }

}



