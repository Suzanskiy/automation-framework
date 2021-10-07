package com.racetrac.mobile.anonymous.bottomNavigation;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NavigationFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BottomNavigationTest extends BaseTest {

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    NavigationFlow navigationFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;

    @TmsLink("1794")
    @Description("Anonymous - Is user able to open application")
    @Test
    public void isHomePageOpenedTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }

    @TmsLink("1796")
    @Description("Anonymous is user able to navigate to Store Tab without Location service")
    @Test
    public void isStoreTabOpenedTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        navigationFlow.navigateToStores();
        locationRequestFlow.clickContinue();
        assertTrue(navigationFlow.isStoresTabOpened(), "Stores page is not opened");
    }

    @TmsLink("1798")
    @Description("Anonymous - is user able navigate to Coupons tab")
    @Test
    public void isCouponsTabOpenedTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        navigationFlow.navigateToCoupons();
        assertTrue(navigationFlow.isCouponsTabOpened(), "Coupons tab is not opened");
    }

    @TmsLink("2309")
    @Description("Anonymous - is user able navigate to Cards screen via navbar")
    @Test
    public void isCardsScreenOpenedTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        navigationFlow.navigateToCards();
        assertTrue(navigationFlow.isCardsTabOpened(), "Cards tab is not opened");
    }

    @TmsLink("2320")
    @Description("Anonymous - is user able navigate to Inbox screen via navbar")
    @Test
    public void isInboxScreenOpenedTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        navigationFlow.navigateToInbox();
        assertTrue(navigationFlow.isInboxTabOpened());
    }
}
