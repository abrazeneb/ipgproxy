package com.sepacyber.ipgproxy.shared.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class ErrorWithFieldErrorsDto extends ErrorDto {

    private List<FieldError> fieldErrors;

    //for multiple method argument validation error handling
    @Data
    @AllArgsConstructor
    public static class FieldError{

        private String filedName;
        private String fieldError;
    }
}
