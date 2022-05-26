package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryPaymentInstallmentsCommandDto  implements Serializable {
    private static final long serialVersionUID = -6708211002129400637L;
    private Long tenantId;
    private String organizationId;
    private String registrationId;
    private String token;
}
