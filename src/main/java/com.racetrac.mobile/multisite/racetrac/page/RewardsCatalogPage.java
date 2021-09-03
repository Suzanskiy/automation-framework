package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RewardsCatalogPage extends BaseMobilePage {
    @iOSXCUITFindBy(accessibility = "NavBarClose")
    private MobileElement closeBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"REDEEM\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/redeemButton")
    private MobileElement redeemBtn;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/button_redeem")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"REDEEM\"]")
    private MobileElement redeemPopupBtn;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/unclaimedRewardsLabel")
    @iOSXCUITFindBy(accessibility = "Unclaimed Rewards")
    private MobileElement unclaimedRewardsLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/memberPoints")
    private MobileElement rewardsCatalogNumberOfPoints;

}
