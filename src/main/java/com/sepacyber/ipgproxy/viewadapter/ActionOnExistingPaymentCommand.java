package com.sepacyber.ipgproxy.viewadapter;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@AllArgsConstructor
@SuperBuilder
public abstract class ActionOnExistingPaymentCommand implements Serializable {
    private static final long serialVersionUID = -1402496870962761215L;
}
