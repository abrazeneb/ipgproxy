package com.sepacyber.ipgproxy.infrastructure.orika;

import com.sepacyber.ipgproxy.applicationcore.ports.out.dto.OrganizationDto;
import com.sepacyber.ipgproxy.domainabstraction.integrationhandler.businessdetailservice.OrganizationResponse;
import com.sepacyber.ipgproxy.shared.mapper.ConfigurableMapperConfigurer;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrganizationMapperConfigurer implements ConfigurableMapperConfigurer {
    @Override
    public void configure(MapperFactory factory) {
        factory.classMap(OrganizationResponse.OrganizationResponsePayload.class, OrganizationDto.class) //source to destination
                .field("additionalData{key}", "additionalData{key}")
                .field("additionalData{value}", "additionalData{value}")
                .byDefault()
                .register();
    }
}
