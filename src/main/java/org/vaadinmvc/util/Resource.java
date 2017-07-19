package org.vaadinmvc.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public enum Resource
{
    IMG_LOGO("/images/test.png");

    @Getter
    private final String path;
}