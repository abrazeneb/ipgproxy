package com.sepacyber.ipgproxy.shared.exception;

import com.sepacyber.ipgproxy.shared.exception.error.ErrorDto;

public class OrganizationAdditionalDataNotFoundException extends BusinessServiceIntegrationException {
    private static final long serialVersionUID = -7429778193707830943L;

    public OrganizationAdditionalDataNotFoundException(ErrorDto error) {
        super(error);
    }
}
