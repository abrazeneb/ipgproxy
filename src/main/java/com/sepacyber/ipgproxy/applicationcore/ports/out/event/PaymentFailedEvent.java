package com.sepacyber.ipgproxy.applicationcore.ports.out.event;

import an.awesome.pipelinr.Notification;
import com.sepacyber.ipgproxy.shared.exception.error.ErrorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PaymentFailedEvent extends BasePaymentEvent implements Notification {
    private ErrorDto error;
}
