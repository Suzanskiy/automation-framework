package com.racetrac.mobile.framework.constants;

import static java.util.concurrent.TimeUnit.SECONDS;

public final class TimeoutConstants {

    public static final int SOCKET_TIMEOUT = (int) SECONDS.toMillis(60 * 10);
    public static final int CONNECTION_TIMEOUT = (int) SECONDS.toMillis(60 * 2);
    public static final int IMPLICIT_WAIT = 0;

    public static final int SLEEP_IN_MILLIS = 1000;

    public static final int LONG_TIMEOUT = 30;
    public static final int CLP_PRODUCT_LOAD_TIMEOUT = 60;
    public static final int ASSERT_TIMEOUT = 5;
    public static final int LONG_ASSERT_TIMEOUT = 10;
    public static final int WEB_ELEMENT_VISIBILITY_MEDIUM_TIMEOUT = 10;
    public static final int SHORT_TIMEOUT = 3;
    public static final int ELEMENT_AFTER_SCROLL_SHORT_CHECK_TIMEOUT = 1;
    public static final int WEB_ELEMENT_FIND_TIMEOUT = 5;
    public static final int VIES_SYNC_TIMEOUT = 50;
    public static final int PRELOADING_TIMEOUT = 2;

    public static final int EMAIL_RETRIEVE_TIMEOUT = 90000;

    private TimeoutConstants() {
    }

}
