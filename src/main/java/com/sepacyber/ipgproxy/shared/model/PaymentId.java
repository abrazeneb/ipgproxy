package com.sepacyber.ipgproxy.shared.model;

import com.sepacyber.ipgproxy.applicationcore.domain.ValueObject;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class PaymentId implements ValueObject, Serializable {
    private final UUID id;

    public PaymentId(@NotNull UUID uuid) {
        this.id = Objects.requireNonNull(uuid);
    }

    public @NotNull UUID unwrap() {
        return id;
    }
}
