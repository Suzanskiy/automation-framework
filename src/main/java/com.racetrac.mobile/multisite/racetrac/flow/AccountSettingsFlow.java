package com.racetrac.mobile.multisite.racetrac.flow;

public interface AccountSettingsFlow extends NavigateFlow {

    boolean isAccountSettingsScreenOpened();

    boolean isAccountSettingsAuthorisedUserScreenOpened();

    boolean isProfileScreenOpened();

    void navigateToAccountSettings();

    void closeAccountSettingsScreen();

    void navigateToProfile();

    void navigateToPromotionalSettings();

    boolean isReceiveEmailsDisplayed();

    boolean receiveEmailsSwitcherPosition();

    void waitUntilAccountSettingsAuthorizedOpen();

    void navigateToHelpSection();


}