package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response;

import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.Bankaccount;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class IpgCardsAndAccountsResponse extends IpgBaseResponseDto {
    private Long partnerId;
    private Long memberId;
    private Long customerId;
    private List<Card> cards;
    private List<Bankaccount> bankAccounts;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Card {
        private String registrationId;
        private String registrationStatus;
        private String cardType;
        private String bin;
        private String last4Digits;
        private String expiryMonth;
        private String expiryYear;
    }
}
