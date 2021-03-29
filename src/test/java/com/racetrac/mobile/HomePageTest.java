package com.racetrac.mobile;

import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseTest {

    @Autowired
    WelcomeFlow welcomeFlow;

    @TmsLink("1794")
    @Description("Anonymous - Is user able to open application")
    @Test
    public void isHomePageOpenedTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }
}
