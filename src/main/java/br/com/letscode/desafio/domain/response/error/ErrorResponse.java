package br.com.letscode.desafio.domain.response.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ErrorResponse {
    private String message;
    private List<ObjectError> errorList;
    public static final String ERROR_RESPONSE_VALIDATION_MODEL = "{\n"
            + "  \"message\": \"string\",\n"
            + "  \"errorList\": [\n"
            + "     {\n"
            + "        \"message\": \"string\",\n"
            + "        \"field\": \"string\"\n"
            + "     }\n"
            + "  ]\n"
            + "}";
    public static final String ERROR_RESPONSE_EXCEPTION_MODEL = "{\n"
            + "  \"message\": \"string\",\n"
            + "}";
}
