package com.sepacyber.ipgproxy.application.ports.in.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentCardResult {
    public String bin;
    public String last4Digits;
    public String holder;
    public String expiryMonth;
    public String expiryYear;
}
