package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.configurer;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.PayWithCardCommandDto;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request.AuthenticationDto;
import com.sepacyber.ipgproxy.shared.mapper.ConfigurableMapperConfigurer;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IpgFactoryMapperConfigurer implements ConfigurableMapperConfigurer {
    @Override
    public void configure(MapperFactory factory) {
            factory.classMap(PayWithCardCommandDto.class, AuthenticationDto.class)
                .customize(new CustomMapper<>() {
                    @Override
                    public void mapAtoB(PayWithCardCommandDto source, AuthenticationDto destination, MappingContext context) {
                    }
                }).register();
    }
}
