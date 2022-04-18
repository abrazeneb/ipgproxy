package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandShippingAddress implements Serializable {

    private static final long serialVersionUID = -4306770203491829728L;
    private String country;
    private String city;
    private String state;
    private String postcode;
    private String street1;
    private String telnocc;
    private String phone;
    private String email;
}
