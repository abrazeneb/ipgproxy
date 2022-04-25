package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PaymentCaptureCommandDto.class, name = "capture"),
        @JsonSubTypes.Type(value = PaymentReversalCommandDto.class, name = "reverse"),
        @JsonSubTypes.Type(value = PaymentStatusCommandDto.class, name = "status"),
        @JsonSubTypes.Type(value = PaymentTransactionBulkQueryCommandDto.class, name = "query")
})
public abstract class AbstractActionOnPaymentCommandDto implements Serializable {
    private static final long serialVersionUID = -5512952739561463672L;
}
