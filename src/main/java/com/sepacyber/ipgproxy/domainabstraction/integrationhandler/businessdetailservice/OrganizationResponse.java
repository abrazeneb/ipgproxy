package com.sepacyber.ipgproxy.domainabstraction.integrationhandler.businessdetailservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationResponse {
    private OrganizationResponsePayload value;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrganizationResponsePayload {
        private String id;
        private String legalName;
        private String tradingName;
        private String tenantId;
        private String tenantName;
        private List<KeyValue> additionalData;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class KeyValue {
            private String key;
            private String value;
        }
    }
}
