package com.sepacyber.ipgproxy.provideradapter.ipg.payment.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private int code;
    private String description;
}
