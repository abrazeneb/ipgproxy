package com.sepacyber.ipgproxy.shared.mapper;

import ma.glasnost.orika.MapperFactory;

@FunctionalInterface
public interface ConfigurableMapperConfigurer {

    void configure(MapperFactory factory);
}
