package com.sepacyber.ipgproxy.provideradapter.ipg.payment;

import lombok.*;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

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
        private LocalDate fromdate;
        private LocalDate todate;

    }

}
