package com.sepacyber.ipgproxy.domainabstraction.repository;

import com.sepacyber.ipgproxy.applicationcore.domain.BaseAggregateRoot;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <Aggregate extends BaseAggregateRoot<ID>, ID extends Serializable>
        extends JpaRepository<Aggregate, ID>, JpaSpecificationExecutor<Aggregate> {

    default @NotNull Aggregate getById(@NotNull ID id) {
        return findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }
}
