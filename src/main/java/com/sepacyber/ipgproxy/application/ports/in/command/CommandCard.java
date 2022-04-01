package com.sepacyber.ipgproxy.application.ports.in.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandCard implements Serializable {

    private static final long serialVersionUID = -4928786568792283035L;
    private String number;
    private String expiryMonth;
    private String expiryYear;
    private String cvv;
}