package com.sepacyber.ipgproxy.applicationcore.ports.in.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThreeDSecureRedirectResult implements Serializable {
    private static final long serialVersionUID = -1062165879919546920L;
    private String url;
    private String method;
    private String target;
    private List<NameValueParameter> parameters;
}
