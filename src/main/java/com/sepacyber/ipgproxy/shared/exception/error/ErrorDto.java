package com.sepacyber.ipgproxy.shared.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ErrorDto {

    private int code;
    private String message;
    private DetailError detailError; //This is added in case we want to return ipg/integration specific error codes
    private List<FieldError> fieldErrors;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Builder.Default
    private Date timestamp = new Date();

    @Data
    @Builder
    @AllArgsConstructor
    public static class DetailError {
        private int detailCode;
        private String detailMessage;

        public DetailError(int detailCode) {
            this.detailCode = detailCode;
        }
    }

    //for multiple method argument validation error handling
    @Data
    @AllArgsConstructor
    public static class FieldError{

        private String filedName;
        private String fieldError;
    }

    @Override
    public String toString(){
        return String.join(" ","Code:", String.valueOf(code), "Message:", message);
    }

}
