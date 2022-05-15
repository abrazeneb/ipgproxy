package com.sepacyber.ipgproxy.applicationcore.ports.out.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private String id;
    private String legalName;
    private String tradingName;
    private long tenantId;
    private String tenantName;
    private Map<String, String> additionalData;
}
