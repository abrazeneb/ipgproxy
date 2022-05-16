package com.sepacyber.ipgproxy.shared.exception;

import com.sepacyber.ipgproxy.shared.exception.error.ErrorDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AbstractIpgException extends RuntimeException{

    private static final long serialVersionUID = 326422769592199702L;

    private final ErrorDto error;

    public AbstractIpgException(ErrorDto error) {
        super(error.getMessage());
        this.error = error;
    }
}
