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
public class ThreeDSecurePaymentResponse extends AbstractPaymentResponse implements Serializable {
    private static final long serialVersionUID = -3077355140909730026L;

    private String paymentType;
    private ThreeDSecureRedirectResponse redirect;
}
