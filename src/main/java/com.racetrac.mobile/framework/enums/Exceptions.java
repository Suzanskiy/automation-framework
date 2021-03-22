package com.racetrac.mobile.framework.enums;

public enum Exceptions {
    UNKNOWN_PLATFORM("Unknown mobile platform"),
    UNCLEAR_TYPE("Unclear type of mobile app"),
    WRONG_NAME("Wrong name"),
    UNCLEAR_NAME("Unclear name of the device"),
    NO_PAGE_LOADING("Can`t get any fields of MobileElement with @PageLoading"),
    FAIL_TO_LOAD_PROPERTIES("Failed to load build properties file.");

    public final String message;

    Exceptions(String message) {
        this.message = message;
    }
}
