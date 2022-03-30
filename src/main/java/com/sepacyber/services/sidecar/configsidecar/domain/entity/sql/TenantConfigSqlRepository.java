package com.sepacyber.services.sidecar.configsidecar.domain.entity.sql;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TenantConfigSqlRepository extends JpaRepository<TenantConfigEntity, UUID> {

    TenantConfigEntity getByTenantId(String tenantId);
}
