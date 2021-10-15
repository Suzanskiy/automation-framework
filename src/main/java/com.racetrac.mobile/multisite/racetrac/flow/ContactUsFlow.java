package com.racetrac.mobile.multisite.racetrac.flow;

public interface ContactUsFlow {
    boolean isContactUsPageOpened();

    boolean isTollFreeCallAvailable();

    void sendMessageToGeneralSubject(String message);
}
