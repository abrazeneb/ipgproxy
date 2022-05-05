package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.configurer;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.PaginationUtil;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.PayWithCardCommandDto;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.IpgPaginationUtil;
import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request.AuthenticationDto;
import com.sepacyber.ipgproxy.shared.mapper.ConfigurableMapperConfigurer;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

import static java.util.Objects.nonNull;

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

            factory.classMap(PaginationUtil.Pagination.class, IpgPaginationUtil.IpgPagination.class)
                    .customize(new CustomMapper<>() {
                        @Override
                        public void mapAtoB(PaginationUtil.Pagination source, IpgPaginationUtil.IpgPagination destination, MappingContext context) {

                            destination.setPageno(source.getPageno());
                            destination.setRecords(source.getRecords());
                            destination.setFromdate(
                                    nonNull(source.getFromdate())
                                            ? source.getFromdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                            : null);
                            destination.setTodate(
                                    nonNull(source.getTodate())
                                            ? source.getTodate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                    : null);
                        }
                    }).register();
    }
}
