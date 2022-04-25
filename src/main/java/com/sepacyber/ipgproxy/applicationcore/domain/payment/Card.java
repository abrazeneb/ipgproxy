package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.Entity;

public class Card implements Entity {
    private String number;
    private String expiryMonth;
    private String expiryYear;
    private String cvv;
    private String holder;
}
