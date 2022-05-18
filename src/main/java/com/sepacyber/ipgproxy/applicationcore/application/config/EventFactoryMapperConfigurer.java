package com.sepacyber.ipgproxy.applicationcore.application.config;

import com.sepacyber.ipgproxy.shared.mapper.ConfigurableMapperConfigurer;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventFactoryMapperConfigurer implements ConfigurableMapperConfigurer {
    @Override
    public void configure(MapperFactory factory) {
      /*  factory.classMap(SynchronousPaymentCommandDto.class, PaymentProcessedEvent.class)
                .customize(new CustomMapper<SynchronousPaymentCommandDto, PaymentProcessedEvent>() {
                    @Override
                    public void mapAtoB(SynchronousPaymentCommandDto source, PaymentProcessedEvent destination, MappingContext context) {
                        super.mapAtoB(source, destination, context);
                        //destination.setBusinessId(source.getBusiness.id);
                    }
                }).register();*/
    }
}
