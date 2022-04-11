package com.sepacyber.ipgproxy.application.ports.in.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandDeviceDetail implements Serializable {
    private static final long serialVersionUID = 3875629598738938227L;

    private String browserAcceptHeader;
    @JsonProperty("user_Agent")
    private String userAgent;
    private String browserLanguage;
    private Integer browserTimezoneOffset;
    private Integer browserColorDepth;
    private Integer browserScreenHeight;
    private Integer browserScreenWidth;
    private String browserJavaEnabled;

}
