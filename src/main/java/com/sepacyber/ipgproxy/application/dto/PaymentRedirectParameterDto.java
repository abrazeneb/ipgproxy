package com.sepacyber.ipgproxy.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRedirectParameterDto implements Serializable {
    private static final long serialVersionUID = -3182139806840655391L;
    private String name;
    private String value;
}
