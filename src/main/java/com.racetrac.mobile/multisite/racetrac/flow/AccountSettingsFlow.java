package com.racetrac.mobile.multisite.racetrac.flow;

public interface AccountSettingsFlow {

    boolean isAccountSettingsScreenOpened();

    boolean isAccountSettingsAuthorisedUserScreenOpened();

    boolean isProfileScreenOpened();

    void navigateToAccountSettings();

    void closeAccountSettingsScreen();

    void navigateToProfile();

    void navigateToPromotionalSettings();

}