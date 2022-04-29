package com.sepacyber.ipgproxy.applicationcore.ports.in.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentStatusBulkResponse implements Serializable {
    private static final long serialVersionUID = -6302648796049329061L;
    private List<ExistingPaymentActionResponse> payments;
}
