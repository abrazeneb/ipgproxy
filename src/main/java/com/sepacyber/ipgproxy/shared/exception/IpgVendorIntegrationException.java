package com.sepacyber.ipgproxy.shared.exception;

import com.sepacyber.ipgproxy.shared.exception.error.ErrorDto;
import lombok.Getter;

@Getter
public class IpgVendorIntegrationException extends AbstractIpgException{
    private static final long serialVersionUID = -8429832336593454731L;

    public IpgVendorIntegrationException(ErrorDto error) {
        super(error);
    }
}
