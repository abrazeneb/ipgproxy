package com.sepacyber.ipgproxy.provideradapter.ipg;

import com.sepacyber.ipgproxy.application.ports.out.CardPaymentPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IpgCardPaymentService  implements CardPaymentPort {
    @Override
    public void pay() {
        log.debug("Processing ipg card payment");
    }
}
