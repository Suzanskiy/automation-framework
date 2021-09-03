package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class HowItWorksPage extends PointsAndLevelsPage {
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/logo_scan")
    private MobileElement scanLogo;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Scan your Rewards + Debit Card or enter your phone number on the pinpad of the pump to earn points.\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/logo_scan_desc")
    private MobileElement scanLogoDescription;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/logo_scan_desc")
    private MobileElement earnLogo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Earn 4 points for every $1 spent on qualifying products and 1 point for every gallon of fuel purchased.\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/logo_earn_description")
    private MobileElement earnLogoDescription;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/logo_redeem")
    private MobileElement redeemLogo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Use your points to redeem free items listed in the rewards catalog.\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/logo_redeem_description")
    private MobileElement redeemLogoDescription;


}
