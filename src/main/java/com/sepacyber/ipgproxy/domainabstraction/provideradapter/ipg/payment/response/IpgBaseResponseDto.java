package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class IpgBaseResponseDto implements Serializable {
    private static final long serialVersionUID = 2382311669424303168L;
    private IpgResultDto result;
}
