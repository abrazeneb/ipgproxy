package com.sepacyber.ipgproxy.applicationcore.domain;

import org.springframework.data.domain.Persistable;
import org.springframework.data.util.ProxyUtils;
import org.springframework.lang.Nullable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Optional;

@MappedSuperclass
public abstract class BaseEntity<Id extends Serializable> implements Persistable<Id> {

    @Version
    private Long version;
    @Override
    @Transient
    public abstract @Nullable Id getId();

    @Override
    @Transient
    public boolean isNew() {
        return getId() == null;
    }

    public @NotNull Optional<Long> getVersion() {
        return Optional.ofNullable(version);
    }

    protected void setVersion(@Nullable Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return String.format("%s{id=%s}", getClass().getSimpleName(), getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(ProxyUtils.getUserClass(obj))) {
            return false;
        }

        var that = (BaseEntity<?>) obj;
        var id = getId();
        return id != null && id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        var id = getId();
        return id == null ? super.hashCode() : id.hashCode();
    }
}
