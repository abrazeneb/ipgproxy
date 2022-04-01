package com.sepacyber.ipgproxy.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRedirectDto implements Serializable {
    private static final long serialVersionUID = -1395991343424307681L;
    private String url;
    private String method;
    private String target;
    private List<PaymentRedirectParameterDto> parameters;
}
