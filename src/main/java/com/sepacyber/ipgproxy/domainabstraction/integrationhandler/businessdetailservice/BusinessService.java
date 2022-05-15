package com.sepacyber.ipgproxy.domainabstraction.integrationhandler.businessdetailservice;

import com.sepacyber.ipgproxy.applicationcore.ports.out.BusinessServicePort;
import com.sepacyber.ipgproxy.applicationcore.ports.out.dto.OrganizationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BusinessService implements BusinessServicePort {

    private final BusinessServiceApiClient apiClient;
    private final MapperFacade mapper;

    //TODO: make this method cacheable
    //TODO: validate the response
    public OrganizationDto getOrganization(long tenantId, String organizationId) {
        log.debug("Getting organization with id {}", organizationId);
        var response = apiClient.getOrganizationById(tenantId, organizationId);
        log.debug("Received organization data with response {}", response.getBody().getValue());
        return mapper.map(response.getBody().getValue(), OrganizationDto.class);
    }
}

