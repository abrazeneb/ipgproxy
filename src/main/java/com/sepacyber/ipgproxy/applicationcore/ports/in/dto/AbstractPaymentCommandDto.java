package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
        property = "type", defaultImpl = SynchronousPaymentCommandDto.class, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AsyncPaymentCommandDto.class, name = "async"),
        @JsonSubTypes.Type(value = SynchronousPaymentCommandDto.class, name = "sync"),
        @JsonSubTypes.Type(value = ThreeDSecurPaymentCommandDto.class, name = "3DSecure")
})
public abstract class AbstractPaymentCommandDto implements Serializable {
    private static final long serialVersionUID = 2909665394413315747L;
    private String merchantTransactionId;
    private Double amount;
    private String currency;
    private String paymentBrand;
    private String paymentMode;
    private String paymentType;
    private String merchantRedirectUrl;
    private Map<String, String> paymentAdditionalData; //paymentAddtionalData.get(secKey)
    private Long accountId;
    private Long terminalId;
}
