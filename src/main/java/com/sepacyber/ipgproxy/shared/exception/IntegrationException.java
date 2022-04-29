package com.sepacyber.ipgproxy.shared.exception;

import lombok.Getter;

@Getter
public class IntegrationException extends RuntimeException{
    private static final long serialVersionUID = -8429832336593454731L;

    private final int statusCode;

    public IntegrationException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
