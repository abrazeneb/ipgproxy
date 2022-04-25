package com.sepacyber.ipgproxy.viewadapter.rest.command;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AbstractPaymentCommandDto;
import com.sepacyber.ipgproxy.viewadapter.PaymentCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class RestPaymentCommand extends PaymentCommand {
    private static final long serialVersionUID = -7934385022536460790L;

    private AbstractPaymentCommandDto data;
}
