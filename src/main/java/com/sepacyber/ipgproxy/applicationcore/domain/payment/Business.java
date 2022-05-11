package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;


@Data
@javax.persistence.Entity
@Table(name = "order")
public class Business implements Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "tenantId")
    private String tenantId;
    @Column(name = "tenantName")
    private String tenantName;
    @OneToOne
    private Payment payment;

    @ElementCollection
    @MapKeyColumn(name="name")
    @Column(name="value")
    @CollectionTable(name="business_data", joinColumns=@JoinColumn(name="id"))
    private Map<String, String> businessData;
}
