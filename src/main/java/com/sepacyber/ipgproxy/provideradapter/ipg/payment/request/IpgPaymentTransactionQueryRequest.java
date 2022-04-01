package com.sepacyber.ipgproxy.provideradapter.ipg.payment.request;

import com.sepacyber.ipgproxy.provideradapter.ipg.payment.IpgPaginationUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpgPaymentTransactionQueryRequest implements Serializable {

    private static final long serialVersionUID = 8142777552640312968L;
    private AuthenticationDto authentication;
    private Integer pageno;
    private Integer records;
    private LocalDate fromdate;
    private LocalDate todate;
    private String status;
    private IpgPaginationUtil.IpgPagination pagination;

}
