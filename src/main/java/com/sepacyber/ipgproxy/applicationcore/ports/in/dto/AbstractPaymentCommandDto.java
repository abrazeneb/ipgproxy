package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
        property = "type", defaultImpl = SynchronousPaymentCommandDto.class, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AsyncPaymentCommandDto.class, name = "async"),
        @JsonSubTypes.Type(value = SynchronousPaymentCommandDto.class, name = "sync"),
        @JsonSubTypes.Type(value = ThreeDSecurePaymentCommandDto.class, name = "3DSecure")
})
public abstract class AbstractPaymentCommandDto implements Serializable {
    private static final long serialVersionUID = 2909665394413315747L;
    private long tenantId;
    private String organizationId;
}