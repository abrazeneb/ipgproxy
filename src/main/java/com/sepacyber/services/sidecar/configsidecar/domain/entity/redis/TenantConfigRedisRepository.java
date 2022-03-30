package com.sepacyber.services.sidecar.configsidecar.domain.entity.redis;

import java.util.Map;

public interface TenantConfigRedisRepository {

    void save(TenantConfigCacheEntity tenantConfigCacheEntity);

    TenantConfigCacheEntity get(String tenantId);

    void update(TenantConfigCacheEntity tenant);

    Map<String, TenantConfigCacheEntity> getAll();

    void delete(String tenantId);

    void saveAll(Map<String, TenantConfigCacheEntity> map);

}
