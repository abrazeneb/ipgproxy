@TypeDef(defaultForType = PaymentId.class, typeClass = PaymentIdType.class)
@GenericGenerator(name = Payment.ID_GENERATOR_NAME, strategy = PaymentIdGenerator.STRATEGY)
package com.sepacyber.ipgproxy.infrastructure.hibernate;

import com.sepacyber.ipgproxy.applicationcore.domain.payment.Payment;
import com.sepacyber.ipgproxy.shared.model.PaymentId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.TypeDef;