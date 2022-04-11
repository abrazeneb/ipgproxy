package com.sepacyber.ipgproxy.provideradapter.ipg.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AttemptThreeDType {
    DIRECT("Direct"),
    THREE_D("3D"),
    ONLY_3D("Only3D");

    @Getter
    private final String value;
}
