package com.racetrac.mobile.multisite.racetrac.flow;

public interface NavigationFlow {
    void navigateToHome();

    void navigateToStores();

    void navigateToCoupons();

    void navigateToCards();

    void navigateToInbox();

    boolean isHomeTabOpened();

    boolean isStoresTabOpened();

    boolean isCouponsTabOpened();

    boolean isCardsTabOpened();

    boolean isInboxTabOpened();

    void navigateToCheckout();

    boolean isRewardCatalogDisplayed();

    void navigateToRewardsCatalogViaDrawer();

    void rewardCatalogClick();

    void navigateToHomeFromCouponsPage();

    boolean isNearestStorePageOpened();
}
