package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg.payment;

import lombok.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class IpgPaginationUtil {

    @Setter
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class IpgPagination {
        @Builder.Default
        private Integer pageno=1;
        @Builder.Default
        private Integer records = Integer.MAX_VALUE;
        // date string in "dd/mm/yyyy" format
        private String fromdate;
        // date string in "dd/mm/yyyy" format
        private String todate;

    }

}
