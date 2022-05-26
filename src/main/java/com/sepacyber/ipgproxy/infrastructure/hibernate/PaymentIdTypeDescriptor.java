package com.sepacyber.ipgproxy.infrastructure.hibernate;

import com.sepacyber.ipgproxy.shared.model.PaymentId;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor;

import java.util.UUID;
/*
    reference https://dev.to/peholmst/using-value-objects-as-aggregate-identifiers-with-hibernate-a2e
 */
public class PaymentIdTypeDescriptor extends AbstractTypeDescriptor<PaymentId> {

   public PaymentIdTypeDescriptor() {
       super(PaymentId.class);
   }

    @Override
    public String toString(PaymentId value) {
        return UUIDTypeDescriptor.ToStringTransformer.INSTANCE.transform(value.unwrap());
    }

    @Override
    public PaymentId fromString(String string) {
        return new PaymentId(UUIDTypeDescriptor.ToStringTransformer.INSTANCE.parse(string));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <X> X unwrap(PaymentId value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (getJavaType().isAssignableFrom(type)) {
            return (X) value;
        }
        if (UUID.class.isAssignableFrom(type)) {
            return (X) UUIDTypeDescriptor.PassThroughTransformer.INSTANCE.transform(value.unwrap());
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) UUIDTypeDescriptor.ToStringTransformer.INSTANCE.transform(value.unwrap());
        }
        if (byte[].class.isAssignableFrom(type)) {
            return (X) UUIDTypeDescriptor.ToBytesTransformer.INSTANCE.transform(value.unwrap());
        }
        throw unknownUnwrap(type);
    }

    @Override
    public <X> PaymentId wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (getJavaType().isInstance(value)) {
            return getJavaType().cast(value);
        }
        if (value instanceof UUID) {
            return new PaymentId(UUIDTypeDescriptor.PassThroughTransformer.INSTANCE.parse(value));
        }
        if (value instanceof String) {
            return new PaymentId(UUIDTypeDescriptor.ToStringTransformer.INSTANCE.parse(value));
        }
        if (value instanceof byte[]) {
            return new PaymentId(UUIDTypeDescriptor.ToBytesTransformer.INSTANCE.parse(value));
        }
        throw unknownWrap(value.getClass());
    }

    public static final PaymentIdTypeDescriptor INSTANCE = new PaymentIdTypeDescriptor();
}
