package com.sepacyber.ipgproxy.viewadapter.rest.command;

import com.sepacyber.ipgproxy.applicationcore.ports.in.dto.AbstractActionOnPaymentCommandDto;
import com.sepacyber.ipgproxy.viewadapter.ActionOnExistingPaymentCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class RestActionOnExistingPaymentCommand  extends ActionOnExistingPaymentCommand {
    private static final long serialVersionUID = -2912727664968862049L;
    @NotBlank(message = "Transaction Id is required")
    private AbstractActionOnPaymentCommandDto data;
}
