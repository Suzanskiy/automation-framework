package com.racetrac.mobile.multisite;

public interface MobilePage {

    boolean waitUntilIsOpened();
    boolean shortWaitUntilIsOpened();

    void refresh();
}
