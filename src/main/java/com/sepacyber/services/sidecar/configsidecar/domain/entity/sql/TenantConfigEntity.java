package com.sepacyber.services.sidecar.configsidecar.domain.entity.sql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

@Table(name = "tenant_config")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@SuperBuilder
public class TenantConfigEntity extends Audited {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tenant_config_id" , columnDefinition = "BINARY(16)")
    @ColumnTransformer(write="uuid_to_bin(?)")
    private UUID tenantConfigId;

    @Column(name = "tenant_id", unique = true, nullable = false)
    private String tenantId;

    @Type(type = "json")
    @Column(name = "meta_data", columnDefinition = "JSON", nullable = false)
    private Map<String, Object> metaData;

    @Column(name = "remark")
    private String remark;

    public TenantConfigEntity() {
        super();
    }
}



