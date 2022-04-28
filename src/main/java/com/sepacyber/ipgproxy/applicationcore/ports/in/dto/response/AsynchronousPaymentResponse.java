package com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsynchronousPaymentResponse extends AbstractPaymentResponse implements Serializable {
    private static final long serialVersionUID = -1082669989318920381L;
    private String status;
    private String firstName;
    private String lastName;
}
