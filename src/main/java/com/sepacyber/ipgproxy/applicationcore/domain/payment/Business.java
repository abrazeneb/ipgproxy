package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.UUID;


public class Business implements Entity {
    private UUID id;
    private String name;
    private UUID tenantId;
    private String tenantName;
    private Map<String, Object> additionalData;
}
