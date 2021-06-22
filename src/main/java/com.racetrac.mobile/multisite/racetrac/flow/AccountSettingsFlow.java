package com.racetrac.mobile.multisite.racetrac.flow;

public interface AccountSettingsFlow {

    boolean isAccountSettingsScreenOpened();

    boolean isAccountSettingsAuthorisedUserScreenOpened();

    void navigateToAccountSettings();

    void closeAccountSettingsScreen();
}