package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.CardCommandDto;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.CustomerCommandDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class IpgPayWithStoredTokenRequest extends IpgOtherActionsBaseRequest {

    private Double amount;
    private String currency;
    private String paymentType;
    private CustomerCommandDto customer;
    private CardCommandDto card;
    private String merchantRedirectUrl;
    private Integer installment;
    private String redirectMethod;
}
