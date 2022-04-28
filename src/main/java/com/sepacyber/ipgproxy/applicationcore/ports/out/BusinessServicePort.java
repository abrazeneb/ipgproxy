package com.sepacyber.ipgproxy.applicationcore.ports.out;

import com.sepacyber.ipgproxy.applicationcore.ports.out.dto.BusinessWithAdditionalDataDto;

import java.util.UUID;

public interface BusinessServicePort {

    BusinessWithAdditionalDataDto getBusinessAdditionalData(UUID businessId);
}
