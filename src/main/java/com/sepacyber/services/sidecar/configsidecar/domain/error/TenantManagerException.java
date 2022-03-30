package com.sepacyber.services.sidecar.configsidecar.domain.error;

public class TenantManagerException extends RuntimeException {

    public TenantManagerException(String message) {
        super(message);
    }

    public TenantManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TenantManagerException(Throwable cause) {
        super(cause);
    }

    public TenantManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
