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
public class CommandCustomer implements Serializable {
    private static final long serialVersionUID = 3944452188194389934L;

    private String email;
    private String givenName;
    private String surname;
    private String ip;
    private String telnocc;
    private String phone;
}
