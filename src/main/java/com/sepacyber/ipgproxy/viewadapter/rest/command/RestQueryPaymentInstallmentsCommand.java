package com.sepacyber.ipgproxy.viewadapter.rest.command;

import com.sepacyber.ipgproxy.viewadapter.QueryPaymentInstallmentsCommand;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class RestQueryPaymentInstallmentsCommand extends QueryPaymentInstallmentsCommand {
    private static final long serialVersionUID = 2397523963962278415L;
    private long tenantId;
    private String organizationId;
    private String registrationId;
    private String token;
}
