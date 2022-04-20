package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.Entity;

import java.util.Map;
import java.util.UUID;

public class Business implements Entity {
    private UUID id;
    private long tenantId;
    private Map<String, Object> additionalData;
}
