package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
        property = "paymentType", defaultImpl = PaymentStatusCommandDto.class, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PaymentRefundCommandDto.class, name = "RF"),
        @JsonSubTypes.Type(value = PaymentCaptureCommandDto.class, name = "CP"),
        @JsonSubTypes.Type(value = PaymentReversalCommandDto.class, name = "RV"),
        @JsonSubTypes.Type(value = PaymentStatusCommandDto.class, name = "IN")
})
public abstract class AbstractActionOnPaymentCommandDto implements Serializable {
    private static final long serialVersionUID = -5512952739561463672L;
    @NotBlank
    private String paymentId;
    private UUID businessId;
    private Map<String, Object> paymentAdditionalData;
}
