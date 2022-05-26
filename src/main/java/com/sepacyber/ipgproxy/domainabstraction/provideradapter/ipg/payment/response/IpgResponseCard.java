package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response;

import java.io.Serializable;

public class IpgResponseCard   implements Serializable {
    private static final long serialVersionUID = 2963409891847638185L;
    private String bin;
    private String last4Digits;
    private String holder;
    private String expiryMonth;
    private String expiryYear;
}
