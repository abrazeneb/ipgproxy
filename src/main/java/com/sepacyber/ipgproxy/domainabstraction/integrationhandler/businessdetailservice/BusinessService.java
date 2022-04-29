package com.sepacyber.ipgproxy.domainabstraction.integrationhandler.businessdetailservice;

import com.sepacyber.ipgproxy.applicationcore.ports.out.BusinessServicePort;
import com.sepacyber.ipgproxy.applicationcore.ports.out.dto.BusinessWithAdditionalDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class BusinessService implements BusinessServicePort {

    private final BusinessServiceApiClient apiClient;
    private final MapperFacade mapper;

    //TODO: make this method cacheable
    //TODO: validate the response
    public BusinessWithAdditionalDataDto getBusinessAdditionalData(UUID businessId) {
        log.debug("Getting business with id {}", businessId);
        var response = apiClient.getBusinessAdditionalData(businessId);
        log.debug("Received business data with response {}", response);
        return mapper.map(response.getBody(), BusinessWithAdditionalDataDto.class);
    }
}

