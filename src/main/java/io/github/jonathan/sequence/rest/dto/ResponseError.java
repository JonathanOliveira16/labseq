package io.github.jonathan.sequence.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseError {

    private String message;

    private Integer statusCode;

}
