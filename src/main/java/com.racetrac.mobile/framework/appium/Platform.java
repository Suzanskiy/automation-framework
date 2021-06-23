package com.racetrac.mobile.framework.appium;

import io.appium.java_client.remote.MobilePlatform;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Platform {
    ANDROID(MobilePlatform.ANDROID, ".apk"),
    IOS(MobilePlatform.IOS, ".app");
    public String platform;
    public String extension;
}
