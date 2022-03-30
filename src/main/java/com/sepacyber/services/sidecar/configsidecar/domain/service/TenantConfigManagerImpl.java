package com.sepacyber.services.sidecar.configsidecar.domain.service;

import com.google.gson.Gson;
import com.sepacyber.services.sidecar.configsidecar.domain.entity.redis.TenantConfigCacheEntity;
import com.sepacyber.services.sidecar.configsidecar.domain.entity.redis.TenantConfigRedisRepository;
import com.sepacyber.services.sidecar.configsidecar.domain.entity.sql.TenantConfigEntity;
import com.sepacyber.services.sidecar.configsidecar.domain.entity.sql.TenantConfigSqlRepository;
import com.sepacyber.services.sidecar.configsidecar.domain.error.TenantManagerException;
import com.sepacyber.services.sidecar.configsidecar.domain.model.TenantConfigAsyncEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;


@Slf4j
@Service("tenantConfigManager")
public class TenantConfigManagerImpl implements TenantConfigManager {

    private static final Gson gson = new Gson();
    private final TenantConfigRedisRepository tenantConfigRedisRepository;
    private final TenantConfigSqlRepository tenantConfigSqlRepository;


    public TenantConfigManagerImpl(TenantConfigRedisRepository tenantConfigRedisRepository, TenantConfigSqlRepository tenantConfigSqlRepository) {

        this.tenantConfigRedisRepository = tenantConfigRedisRepository;
        this.tenantConfigSqlRepository = tenantConfigSqlRepository;

    }

    @Override
    public void saveAndCache(TenantConfigAsyncEvent event) {

        if (null == event) {
            throw new TenantManagerException("null TenantConfigAsyncEvent received");
        }

        if (!StringUtils.hasText(event.getTenantId()) || !StringUtils.hasText(event.getMetaData())) {
            //log.warn("TenantConfigManagerImpl , invalid TenantConfigAsyncEvent TenantId {}  MetaData {} ", event.getTenantId(), event.getMetaData());
            throw new TenantManagerException("invalid TenantConfigAsyncEvent TenantId " + event.getTenantId() + " MetaData " + event.getMetaData());
        }

        if (event.isDelete()) {

            log.info("TenantConfigManagerImpl , processing delete tenant config request for TenantEvent {} ", event);

            deleteTenant(event.getTenantId());
            deleteTenantCache(event.getTenantId());

            log.info("TenantConfigManagerImpl , completed delete tenant config request for TenantEvent {} ", event);
            return;
        }

        log.info("TenantConfigManagerImpl , processing create/update tenant config request for TenantEvent {} ", event);

        saveTenantConfig(event);
        cacheTenantConfig(event);

        log.info("TenantConfigManagerImpl , completed create/update tenant config request for TenantEvent {} ", event);
    }

    @Override
    public void saveTenantConfig(TenantConfigAsyncEvent event) {

        TenantConfigEntity tenantConfigEntity = tenantConfigSqlRepository.getByTenantId(event.getTenantId());

        Map<String, Object> metadataJson = gson.fromJson(event.getMetaData(), Map.class);

        if (tenantConfigEntity == null) {

            tenantConfigEntity = TenantConfigEntity.builder()
                    .tenantId(event.getTenantId())
                    .createdBy(event.getUpdatedBy())
                    .createdDate(event.getUpdatedDate())
                    .metaData(metadataJson)
                    .updatedBy(event.getUpdatedBy())
                    .updatedDate(event.getUpdatedDate())
                    .build();

        } else {

            tenantConfigEntity.setMetaData(metadataJson);
            tenantConfigEntity.setUpdatedBy(event.getUpdatedBy());
            tenantConfigEntity.setCreatedDate(event.getUpdatedDate());

        }

        tenantConfigSqlRepository.save(tenantConfigEntity);

    }

    @Override
    public void cacheTenantConfig(TenantConfigAsyncEvent event) {

        TenantConfigCacheEntity tenantConfigCacheEntity = tenantConfigRedisRepository.get(event.getTenantId());

        if (tenantConfigCacheEntity == null) {

            tenantConfigCacheEntity = TenantConfigCacheEntity.builder()
                    .tenantId(event.getTenantId())
                    .metaData(event.getMetaData())
                    .build();

            tenantConfigRedisRepository.save(tenantConfigCacheEntity);

        } else {

            tenantConfigCacheEntity.setMetaData(event.getMetaData());

            tenantConfigRedisRepository.update(tenantConfigCacheEntity);
        }

    }


    @Override
    public void deleteTenant(String tenantId) {

        TenantConfigEntity tenantConfigEntity = tenantConfigSqlRepository.getByTenantId(tenantId);

        if (tenantConfigEntity == null) {
            return;
        }

        tenantConfigSqlRepository.delete(tenantConfigEntity);
    }

    @Override
    public void deleteTenantCache(String tenantId) {

        TenantConfigCacheEntity tenantConfigCacheEntity = tenantConfigRedisRepository.get(tenantId);

        if (tenantConfigCacheEntity == null) {
            return;
        }

        tenantConfigRedisRepository.delete(tenantId);
    }

}
