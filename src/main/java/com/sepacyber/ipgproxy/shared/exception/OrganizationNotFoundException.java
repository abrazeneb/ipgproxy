package com.sepacyber.ipgproxy.shared.exception;

import com.sepacyber.ipgproxy.shared.exception.error.ErrorDto;

public class OrganizationNotFoundException extends BusinessServiceIntegrationException {
    private static final long serialVersionUID = -5542400179552214123L;

    public OrganizationNotFoundException(ErrorDto error) {
        super(error);
    }
}
