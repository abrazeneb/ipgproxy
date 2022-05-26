package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.BaseAggregateRoot;
import com.sepacyber.ipgproxy.shared.model.PaymentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment extends BaseAggregateRoot<PaymentId> {
    public static final String ID_GENERATOR_NAME = "payment-id-generator";
    @Id
    @GeneratedValue(generator = ID_GENERATOR_NAME)
    private PaymentId id;
    @Column( name = "payment_id", unique = true)
    private String paymentId;
    @Column(name = "merchant_transaction_id")
    private String merchantTransactionId;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "currency")
    private String currency;
    @Column(name = "payment_brand")
    private String paymentBrand;
    @Column(name = "payment_mode")
    private String paymentMode;
    @Column(name = "payment_type")
    private String paymentType;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "terminal_id")
    private Long terminalId;
    @Embedded
    private Business business;
    @Embedded
    private Card card;
    @Embedded
    private Customer customer;
    @ElementCollection
    @MapKeyColumn(name="name")
    @Column(name="value")
    @CollectionTable(name="business_data", joinColumns=@JoinColumn(name="id"))
    private Map<String, String> businessData;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus;

    @Override
    public @Nullable PaymentId getId() {
        return id;
    }

}
