package com.sepacyber.ipgproxy.provideradapter.ipg.configurer;

import com.sepacyber.ipgproxy.application.ports.in.command.PayWithCardCommand;
import com.sepacyber.ipgproxy.provideradapter.ipg.IpgChecksumUtil;
import com.sepacyber.ipgproxy.provideradapter.ipg.payment.request.AuthenticationDto;
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
            factory.classMap(PayWithCardCommand.class, AuthenticationDto.class)
                .customize(new CustomMapper<>() {
                    @Override
                    public void mapAtoB(PayWithCardCommand source, AuthenticationDto destination, MappingContext context) {
                        destination.setAccountId(source.getAccountId());
                        destination.setMemberId(source.getMerchantId());
                        destination.setChecksum(IpgChecksumUtil.generateSyncTransactionAmd5Checksum(source.getMerchantId(),
                                source.getSecureKey(),
                                source.getMerchantTransactionId(),
                                source.getAmount()));
                    }
                }).register();
    }
}
