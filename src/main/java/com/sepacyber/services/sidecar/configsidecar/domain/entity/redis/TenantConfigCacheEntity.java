package com.sepacyber.services.sidecar.configsidecar.domain.entity.redis;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantConfigCacheEntity implements Serializable {

    private static final long serialVersionUID = -1031186363738474227L;

    @Id
    @Indexed
    private String tenantId;
    private String metaData;

}
