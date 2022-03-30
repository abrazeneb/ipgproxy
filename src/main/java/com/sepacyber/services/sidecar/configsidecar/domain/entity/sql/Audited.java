package com.sepacyber.services.sidecar.configsidecar.domain.entity.sql;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by hsolomon
 */
@TypeDefs({@TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonType.class)})
@MappedSuperclass
@Data
public abstract class Audited implements Serializable {

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @PrePersist
    private void setAuditInfo() {

        if (!StringUtils.hasText(createdBy)) {
            this.createdBy = "system";//fixme (current user)
        }

        if (!StringUtils.hasText(updatedBy)) {
            this.updatedBy = "system";//fixme (current user)
        }

        if (createdDate == null) {
            this.createdDate = LocalDateTime.now();
        }

        if (updatedDate == null) {
            this.updatedDate = LocalDateTime.now();
        }
    }

}