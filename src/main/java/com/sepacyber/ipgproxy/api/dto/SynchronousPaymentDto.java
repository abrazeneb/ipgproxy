package com.sepacyber.ipgproxy.api.dto;

import com.sepacyber.ipgproxy.application.ports.in.command.CommandCustomer;
import com.sepacyber.ipgproxy.application.ports.in.command.CommandShippingAddress;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SynchronousPaymentDto implements Serializable {
    private static final long serialVersionUID = -7934385022536460790L;
    @NotBlank(message = "merchantTransactionId is required")
    private String merchantTransactionId;
    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount is required")
    private Double amount;
    @NotBlank(message = "Currency is required")
    private String currency;
    @NotBlank(message = "paymentBrand is required")
    private String paymentBrand;
    @NotBlank(message = "paymentMode is required")
    private String paymentMode;
    @NotBlank(message = "paymentType is required")
    private String paymentType;
    @NotBlank(message = "merchantRedirectUrl is required")
    private String merchantRedirectUrl;
    private String orderDescriptor;
    private CommandShippingAddress shipping;
    private CommandCustomer customer;
    private String notificationUrl;
    private String recurringType;
    private Double tmpl_amount;
    private String tmpl_currency;
    private Boolean createRegistration;
    @Schema(required = false, description = "The payment ID of the previous successful transaction for which the customer wants to place a repeated recurring transactionr")
    private String paymentId;
    @Schema(required = false, description = "the ID is used to fetch card detail of hte customer")
    private String registrationId;
    private CardDto card;
    private Map<String, String> paymentAdditionalData;
    private Long accountId;
    private Long terminalId;
}
