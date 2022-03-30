package com.sepacyber.services.sidecar.configsidecar.domain.entity.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class TenantConfigRedisRepositoryImpl implements TenantConfigRedisRepository {

    private static final String HASH_REFERENCE_POSTFIX = "tenant_config_cache";

    private final String hashReference;
    private final RedisTemplate<String, TenantConfigCacheEntity> redisTemplate;
    private final HashOperations<String, String, TenantConfigCacheEntity> hashOperations;

    public TenantConfigRedisRepositoryImpl(@Value("${app.service.id}") String serviceId, RedisTemplate<String,
            TenantConfigCacheEntity> redisTemplate) {

        this.redisTemplate = redisTemplate;
        this.hashReference = serviceId.concat("_").concat(HASH_REFERENCE_POSTFIX);
        this.hashOperations = this.redisTemplate.opsForHash();

    }

    @Override
    public void save(TenantConfigCacheEntity tenantConfig) {
        hashOperations.putIfAbsent(hashReference, tenantConfig.getTenantId(), tenantConfig);
    }

    @Override
    public TenantConfigCacheEntity get(String tenantId) {
        return hashOperations.get(hashReference, tenantId);
    }

    @Override
    public void update(TenantConfigCacheEntity tenant) {
        hashOperations.put(hashReference, tenant.getTenantId(), tenant);
    }

    @Override
    public Map<String, TenantConfigCacheEntity> getAll() {
        return hashOperations.entries(hashReference);
    }

    @Override
    public void delete(String tenantId) {
        hashOperations.delete(hashReference, tenantId);
    }

    @Override
    public void saveAll(Map<String, TenantConfigCacheEntity> tenants) {
        hashOperations.putAll(hashReference, tenants);
    }

}
