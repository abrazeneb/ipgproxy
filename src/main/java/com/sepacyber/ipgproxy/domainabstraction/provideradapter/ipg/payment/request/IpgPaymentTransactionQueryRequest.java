package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;

import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.IpgPaginationUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IpgPaymentTransactionQueryRequest implements Serializable {

    private static final long serialVersionUID = 8142777552640312968L;
    private String status;
    private IpgPaginationUtil.IpgPagination pagination;

}
