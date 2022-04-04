package com.sepacyber.ipgproxy.provideradapter.ipg.payment;

import java.io.Serializable;

public class Bankaccount implements Serializable {
    private static final long serialVersionUID = -141544938011976107L;
    private String registrationId;
    private String registrationStatus;
    private String iban;
    private String bic;
}
