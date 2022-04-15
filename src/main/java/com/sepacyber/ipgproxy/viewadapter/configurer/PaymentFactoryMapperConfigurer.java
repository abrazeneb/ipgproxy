package com.sepacyber.ipgproxy.viewadapter.configurer;

import com.sepacyber.ipgproxy.applicationcore.application.service.CoreBean;
import com.sepacyber.ipgproxy.shared.mapper.ConfigurableMapperConfigurer;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;

@Slf4j
@CoreBean
public class PaymentFactoryMapperConfigurer implements ConfigurableMapperConfigurer {
    @Override
    public void configure(MapperFactory factory) {

    }
}
