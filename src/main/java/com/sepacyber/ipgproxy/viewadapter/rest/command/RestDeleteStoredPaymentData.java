package com.sepacyber.ipgproxy.viewadapter.rest.command;

import com.sepacyber.ipgproxy.viewadapter.DeleteStoredPaymentDataCommand;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class RestDeleteStoredPaymentData extends DeleteStoredPaymentDataCommand {
    private static final long serialVersionUID = 2735363031780648781L;
    private long tenantId;
    private String organizationId;
    private String registrationId;
}
