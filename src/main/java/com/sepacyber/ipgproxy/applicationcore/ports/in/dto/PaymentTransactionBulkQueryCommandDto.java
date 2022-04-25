package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.IpgPaginationUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PaymentTransactionBulkQueryCommandDto extends AbstractActionOnPaymentCommandDto {

    private static final long serialVersionUID = -3995912404084505770L;
    private Integer pageno;
    private Integer records;
    private LocalDate fromdate;
    private LocalDate todate;
    private String status;
    private IpgPaginationUtil.IpgPagination pagination;
}
