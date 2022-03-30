package com.sepacyber.services.sidecar.configsidecar.domain.service;

import com.sepacyber.services.sidecar.configsidecar.domain.error.TenantManagerException;
import com.sepacyber.services.sidecar.configsidecar.domain.model.TenantConfigAsyncEvent;

public interface TenantConfigManager {

    /**
     * saves and caches the current async tenant configuration event
     *
     * @param event
     * @throws TenantManagerException
     */
    void saveAndCache(TenantConfigAsyncEvent event) throws TenantManagerException;

    /**
     * saves or updates the current tenant config event onto sql data store
     *
     * @param event
     */
    void cacheTenantConfig(TenantConfigAsyncEvent event);

    /**
     * saves or updates the current tenant config event onto in memory data store
     *
     * @param event
     */
    void saveTenantConfig(TenantConfigAsyncEvent event);


    /**
     * deletes tenant config from sql data store
     *
     * @param tenantId
     */
    void deleteTenant(String tenantId);

    /**
     * deletes tenant config from in memeory data store
     *
     * @param tenantId
     */
    void deleteTenantCache(String tenantId);

}
