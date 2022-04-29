package com.sepacyber.ipgproxy.applicationcore.ports.in.dto;

import lombok.*;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class PaginationUtil {

    @Setter
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Pagination {
        @Builder.Default
        private Integer pageno=1;
        @Builder.Default
        private Integer records = Integer.MAX_VALUE;
        private LocalDate fromdate;
        private LocalDate todate;

    }

}
