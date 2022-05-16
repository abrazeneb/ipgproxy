package com.sepacyber.ipgproxy.shared.exception;


import com.sepacyber.ipgproxy.shared.exception.error.ErrorDto;

public class BusinessServiceIntegrationException extends AbstractIpgException {
    private static final long serialVersionUID = -5043390522726061743L;

    public BusinessServiceIntegrationException(ErrorDto error) {
        super(error);
    }
}
