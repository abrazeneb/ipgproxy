package com.sepacyber.ipgproxy.shared.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
public class ErrorDto {

    private int code;
    private String message;
    private DetailError detailError; //This is added in case we want to return ipg/integration specific error codes


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Builder.Default
    private Date timestamp = new Date();

    private String path;


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


    @Override
    public String toString(){
        return String.join(" ","Code:", String.valueOf(code), "Message:", message);
    }

}
