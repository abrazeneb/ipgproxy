package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class IpgExistingPaymentActionBaseRequest implements Serializable {
    private static final long serialVersionUID = -6422970862012994655L;

    private Map<String, Object> paymentAdditionalData;
}
