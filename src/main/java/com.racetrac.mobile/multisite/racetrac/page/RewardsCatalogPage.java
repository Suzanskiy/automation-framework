package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RewardsCatalogPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "NavBarClose")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/reward_catalog_back_btn")
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

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/unclaimedRewardsCounter")
    private MobileElement unclaimedRewardsCounter;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/memberPoints")
    private MobileElement rewardsCatalogNumberOfPoints;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/reward_catalog_back_btn")
    private MobileElement rewardsCatalogBackBtn;

}
