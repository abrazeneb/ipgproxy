package com.sepacyber.ipgproxy.application.ports.in.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardResponse implements Serializable {

    private static final long serialVersionUID = 6463702198314743569L;
    private String bin;
    private String last4Digits;
    private String holder;
    private String expiryMonth;
    private String expiryYear;
}
