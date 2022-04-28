package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PaymentCaptureCommandDto.class, name = "capture"),
        @JsonSubTypes.Type(value = PaymentReversalCommandDto.class, name = "reverse"),
        @JsonSubTypes.Type(value = PaymentStatusCommandDto.class, name = "status")
})
public abstract class AbstractActionOnPaymentCommandDto implements Serializable {
    private static final long serialVersionUID = -5512952739561463672L;
    @NotBlank
    private String transactionId;
}
