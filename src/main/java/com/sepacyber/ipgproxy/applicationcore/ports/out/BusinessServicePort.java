package com.sepacyber.ipgproxy.applicationcore.ports.out;

import com.sepacyber.ipgproxy.applicationcore.ports.out.dto.OrganizationDto;

public interface BusinessServicePort {

    OrganizationDto getOrganization(long tenantId, String organizationId);
}
