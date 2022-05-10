package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class PaymentTransactionBulkQueryCommandDto implements Serializable {

    private static final long serialVersionUID = -3995912404084505770L;
    private String status;
    private long tenantId;
    private String organizationId;
    private PaginationUtil.Pagination pagination;
}
