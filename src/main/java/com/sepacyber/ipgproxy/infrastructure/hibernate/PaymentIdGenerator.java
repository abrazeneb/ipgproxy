package com.sepacyber.ipgproxy.infrastructure.hibernate;

import com.sepacyber.ipgproxy.shared.model.PaymentId;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class PaymentIdGenerator implements IdentifierGenerator {
    public static final String STRATEGY = "com.sepacyber.ipgproxy.infrastructure.hibernate.PaymentIdGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return new PaymentId(UUID.randomUUID());
    }

}
