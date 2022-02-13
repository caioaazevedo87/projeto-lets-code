package br.com.letscode.desafio.exception;


import br.com.letscode.desafio.domain.response.error.ErrorResponse;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
        new ErrorResponse(message, null);
    }

}
