package com.sepacyber.ipgproxy.provideradapter.ipg.payment.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpgResultDto implements Serializable {
    private static final long serialVersionUID = 2915605753712143832L;

    private String code;
    private String description;
}
