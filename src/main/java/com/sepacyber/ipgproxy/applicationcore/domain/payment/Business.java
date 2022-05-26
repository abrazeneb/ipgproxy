package com.sepacyber.ipgproxy.applicationcore.domain.payment;

import com.sepacyber.ipgproxy.applicationcore.domain.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;


@Getter
@Embeddable
public class Business {

    @Column(name = "name")
    private String name;
    @Column(name = "tenant_id")
    private Long tenantId;
    @Column(name = "tenant_name")
    private String tenantName;
    @Column
    private String organizationId;

    @SuppressWarnings("unused")
    protected Business() {
    }

    public Business(String name, Long tenantId, String tenantName, String organizationId) {
        this.name = name;
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.organizationId = organizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Business business = (Business) o;
        return name.equals(business.name)
                && tenantId.equals(business.tenantId)
                && tenantName.equals(business.tenantName)
                && organizationId.equals(business.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tenantId, tenantName, organizationId);
    }
}
