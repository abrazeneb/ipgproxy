package com.sepacyber.ipgproxy.provideradapter.ipg.auth;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Authentication {
    private long partnerId;
    private String sKey;
}
