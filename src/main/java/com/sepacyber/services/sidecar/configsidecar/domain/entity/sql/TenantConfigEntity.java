package com.sepacyber.services.sidecar.configsidecar.domain.entity.sql;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Table(name = "tenant_config")
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantConfigEntity extends Audited {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tenant_config_id")
    private UUID tenantConfigId;

    @Column(name = "tenant_id", unique = true, nullable = false)
    private String tenantId;

    @Type(type = "json")
    @Column(name = "meta_data", columnDefinition = "jsonb", nullable = false)
    private Map<String, Object> metaData;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "remark")
    private String remark;

}



