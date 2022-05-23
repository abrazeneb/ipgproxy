package com.sepacyber.ipgproxy.applicationcore.ports.out.event;

import an.awesome.pipelinr.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@SuperBuilder
public class PaymentProcessedEvent extends BasePaymentEvent implements Notification {

}
