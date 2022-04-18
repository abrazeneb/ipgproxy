package com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse implements Serializable {
    private static final long serialVersionUID = -6073232445865442972L;
    private String data;
}
