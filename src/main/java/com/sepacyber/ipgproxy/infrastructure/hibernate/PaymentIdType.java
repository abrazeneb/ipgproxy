package com.sepacyber.ipgproxy.infrastructure.hibernate;

import com.sepacyber.ipgproxy.shared.model.PaymentId;
import org.hibernate.id.ResultSetIdentifierConsumer;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.BinaryTypeDescriptor;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentIdType  extends AbstractSingleColumnStandardBasicType<PaymentId>
        implements ResultSetIdentifierConsumer {

    public PaymentIdType() {
        super(BinaryTypeDescriptor.INSTANCE, PaymentIdTypeDescriptor.INSTANCE);
    }

    @Override
    public Serializable consumeIdentifier(ResultSet resultSet) {
        try {
            var id = resultSet.getBytes(1);
            return getJavaTypeDescriptor().wrap(id, null);
        } catch (SQLException ex) {
            throw new IllegalStateException("Could not extract ID from ResultSet", ex);
        }
    }

    @Override
    public String getName() {
        return getJavaTypeDescriptor().getJavaType().getSimpleName();
    }

}
