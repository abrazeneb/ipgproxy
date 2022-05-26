package com.sepacyber.ipgproxy.viewadapter.rest.command;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.CardCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.CustomerCommandDto;
import com.sepacyber.ipgproxy.viewadapter.PaymentWithStoredDataCommand;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class RestPaymentWithStoredDataCommand extends PaymentWithStoredDataCommand {

    private static final long serialVersionUID = 7506535828016152555L;
    private long tenantId;
    private String organizationId;
    private Double amount;
    private String currency;
    private String paymentType;
    private CustomerCommandDto customer;
    private CardCommandDto card;
    private String merchantRedirectUrl;
    private Integer installment;
    private String redirectMethod;
}
