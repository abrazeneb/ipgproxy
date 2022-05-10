package com.sepacyber.ipgproxy.domainabstraction.integrationhandler.businessdetailservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.UUID;

@FeignClient(name = "business-service",
        url = "${business.service.url}")
public interface BusinessServiceApiClient {

    @GetMapping("/organization/getById/{id}")
    ResponseEntity<OrganizationResponse> getOrganizationById(@RequestHeader("tenantId") long tenantId, @PathVariable("id") String id);
}
