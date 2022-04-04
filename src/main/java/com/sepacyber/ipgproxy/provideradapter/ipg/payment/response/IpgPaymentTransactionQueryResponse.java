package com.sepacyber.ipgproxy.provideradapter.ipg.payment.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;



@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class IpgPaymentTransactionQueryResponse extends IpgBaseResponseDto {

    private static final long serialVersionUID = -2836038795716614676L;
    private List<IpgPaymentTransaction> transaction;
}
