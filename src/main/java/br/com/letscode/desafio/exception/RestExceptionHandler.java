package br.com.letscode.desafio.exception;

import br.com.letscode.desafio.domain.response.error.ErrorResponse;
import br.com.letscode.desafio.domain.response.error.ObjectError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return new ErrorResponse("Erro na validacao dos campos", buildFieldErrors(ex));
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleRuntimeException(RuntimeException ex) {
        return new ErrorResponse(ex.getMessage(), null);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleRuntimeException(NotFoundException notFoundException) {
        return new ErrorResponse(notFoundException.getMessage(), null);
    }

    private List<ObjectError> buildFieldErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors().stream()
                .map(error -> new ObjectError(error.getDefaultMessage()))
                .collect(Collectors.toList());
    }

}
