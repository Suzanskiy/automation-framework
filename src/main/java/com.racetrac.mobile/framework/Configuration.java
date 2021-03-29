package com.racetrac.mobile.framework;

public final class Configuration {

    private static final String TEST_PROFILE_PROPERTY_NAME = "test.profile";

    private Configuration() {
    }

    public static String getProfile() {
        return getFileProperty(TEST_PROFILE_PROPERTY_NAME);
    }

    private static String getFileProperty(final String key) {
        return PropertiesHolder.getInstance().getProperty(key);
    }

}
