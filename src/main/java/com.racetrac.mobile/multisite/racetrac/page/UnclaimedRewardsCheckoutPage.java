package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UnclaimedRewardsCheckoutPage extends RewardsCheckoutPage {

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Unclaimed Rewards\"]")
    @iOSXCUITFindBy(accessibility = "Unclaimed Rewards")
    private WebElement pageTitle;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"added to your account\")]")
    @iOSXCUITFindBy(accessibility = "Rewards added to your account, but have not been claimed")
    private WebElement unclaimedRewardsInfo;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_unclaimed_title")
    private WebElement unclaimedRewardName;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_unclaimed_timer")
    private WebElement unclaimedRewardTimer;

}
