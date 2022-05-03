package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.request;

import com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment.IpgPaginationUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class IpgPaymentTransactionQueryRequest extends IpgExistingPaymentActionBaseRequest {

    private static final long serialVersionUID = 8142777552640312968L;
    private String status;
    private IpgPaginationUtil.IpgPagination pagination;

}
