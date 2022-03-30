package com.sepacyber.services.sidecar.configsidecar.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantConfigAsyncEvent implements Serializable {

    @Id
    @Indexed
    private String tenantId;
    private String metaData;
    private String updatedBy;
    private LocalDateTime updatedDate;
    private boolean isDelete;

}
