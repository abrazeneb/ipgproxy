package com.sepacyber.ipgproxy.domainabstraction.integrationhandler.businessdetailservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessWithAdditionalDataResponse {
    private UUID id;
    private String name;
    private UUID tenantId;
    private String tenantName;
    private Map<String, Object> additionalData;
}
