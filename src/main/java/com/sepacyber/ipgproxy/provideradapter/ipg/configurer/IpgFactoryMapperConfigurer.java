package com.sepacyber.ipgproxy.provideradapter.ipg.configurer;

import com.sepacyber.ipgproxy.application.ports.in.GetAuthTokenCommand;
import com.sepacyber.ipgproxy.provideradapter.ipg.auth.AuthTokenRequest;
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
        factory.classMap(GetAuthTokenCommand.class, AuthTokenRequest.class)
                .customize(new CustomMapper<GetAuthTokenCommand, AuthTokenRequest>() {
                    @Override
                    public void mapAtoB(GetAuthTokenCommand source, AuthTokenRequest destination, MappingContext context) {
                        destination.setAuthentication(mapperFacade.map(source, AuthTokenRequest.Authentication.class));
                        destination.setMerchant(mapperFacade.map(source, AuthTokenRequest.Merchant.class));
                    }
                }).register();

        factory.classMap(GetAuthTokenCommand.class, AuthTokenRequest.Authentication.class)
                .customize(new CustomMapper<GetAuthTokenCommand, AuthTokenRequest.Authentication>() {
                    @Override
                    public void mapAtoB(GetAuthTokenCommand source, AuthTokenRequest.Authentication destination, MappingContext context) {
                        destination.setSKey(source.getIpgSecureKey());
                        destination.setPartnerId(source.getIpgPartnerId());
                    }
                }).register();


        factory.classMap(GetAuthTokenCommand.class, AuthTokenRequest.Merchant.class)
                .customize(new CustomMapper<GetAuthTokenCommand, AuthTokenRequest.Merchant>() {
                    @Override
                    public void mapAtoB(GetAuthTokenCommand source, AuthTokenRequest.Merchant destination, MappingContext context) {
                        destination.setUsername(source.getIpgUsername());
                    }
                }).register();

    }
}
