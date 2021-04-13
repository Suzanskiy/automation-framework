package com.racetrac.mobile.multisite.racetrac.flow;

public interface NavigationFlow {
    public void navigateToHome();

    public void navigateToStores();

    public void navigateToCoupons();

    public void navigateToCards();

    public void navigateToInbox();

    public boolean isHomeTabOpened();

    public boolean isStoresTabOpened();

    public boolean isCouponsTabOpened();

    public boolean isCardsTabOpened();

    public boolean isInboxTabOpened();
}
