package com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;
@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryPaymentInstallmentsResponse implements Serializable {
    private static final long serialVersionUID = 6840443045879138609L;
    private String registrationId;
    private List<Integer> pendingInstallments;
    private CardResponse card;
}
