package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceDetails implements Serializable {
    private static final long serialVersionUID = -3682307237698998507L;
    private String user_Agent;
    private String browserLanguage;
    private Integer browserTimezoneOffset;
    private Integer browserColorDepth;
    private String browserAcceptHeader;
    private Integer browserScreenHeight;
    private Integer browserScreenWidth;
    private boolean browserJavaEnabled;

}
