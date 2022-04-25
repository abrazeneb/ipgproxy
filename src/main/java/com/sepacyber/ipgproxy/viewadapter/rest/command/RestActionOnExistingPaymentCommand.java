package com.sepacyber.ipgproxy.viewadapter.rest.command;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AbstractActionOnPaymentCommandDto;
import com.sepacyber.ipgproxy.viewadapter.ActionOnExistingPaymentCommand;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Data
@SuperBuilder(toBuilder = true)
public class RestActionOnExistingPaymentCommand  extends ActionOnExistingPaymentCommand {
    private static final long serialVersionUID = -2912727664968862049L;
    @NotBlank(message = "Transaction Id is required")
    private AbstractActionOnPaymentCommandDto data;
}
