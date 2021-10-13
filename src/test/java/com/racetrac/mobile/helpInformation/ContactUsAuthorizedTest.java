package com.racetrac.mobile.helpInformation;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import org.springframework.beans.factory.annotation.Autowired;

public class ContactUsAuthorizedTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    AccountSettingsFlow accountSettingsFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    CustomerDto customerDto;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;


}
