package com.sepacyber.ipgproxy.domainabstraction.integrationhandler.businessdetailservice;

import com.sepacyber.ipgproxy.applicationcore.ports.out.BusinessServicePort;
import com.sepacyber.ipgproxy.applicationcore.ports.out.dto.OrganizationDto;
import com.sepacyber.ipgproxy.shared.exception.OrganizationAdditionalDataNotFoundException;
import com.sepacyber.ipgproxy.shared.exception.OrganizationNotFoundException;
import com.sepacyber.ipgproxy.shared.exception.error.ErrorCode;
import com.sepacyber.ipgproxy.shared.exception.error.ErrorDto;
import feign.FeignException;
import feign.RetryableException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.util.Objects;

import static java.util.Objects.isNull;

@Slf4j
@RequiredArgsConstructor
@Service
public class BusinessService implements BusinessServicePort {

    private final BusinessServiceApiClient apiClient;
    private final MapperFacade mapper;

    //TODO: make this method cacheable?
    //TODO: feign client error handling
    public OrganizationDto getOrganization(long tenantId, String organizationId) {
        log.debug("Getting organization with id {}", organizationId);

        var response = apiClient.getOrganizationById(tenantId, organizationId);

        if (isNull(Objects.requireNonNull(response.getBody()).getValue())) {

            var error = ErrorDto.builder()
                    .code(ErrorCode.ORGANIZATION_NOT_FOUND)
                    .message("Organization with id " + organizationId + " not found")
                    .build();
            throw new OrganizationNotFoundException(error);
        }

        if (CollectionUtils.isEmpty(response.getBody().getValue().getAdditionalData())) {
            var error = ErrorDto.builder()
                    .code(ErrorCode.ORGANIZATION_ADDITIONAL_DATA_NOT_FOUND)
                    .message("No additional data found for organization with id: " + organizationId)
                    .build();
            throw new OrganizationAdditionalDataNotFoundException(error);
        }

        var payload = response.getBody().getValue();

        log.debug("Received organization data with response {}", payload);
        return mapper.map(payload, OrganizationDto.class);

    }
}

