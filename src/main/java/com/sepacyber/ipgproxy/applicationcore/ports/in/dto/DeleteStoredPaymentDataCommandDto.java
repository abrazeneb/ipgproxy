package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteStoredPaymentDataCommandDto implements Serializable {
    private static final long serialVersionUID = -4090833126035314443L;
    private long tenantId;
    private String organizationId;
    private String registrationId;


}
