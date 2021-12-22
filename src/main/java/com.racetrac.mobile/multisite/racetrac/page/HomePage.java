package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class HomePage extends BaseMobilePage {
    private static final String DESCRIPTION_TEXT_WITH_NO_POINTS = "You have no points!";

    @PageLoading
    @iOSXCUITFindBy(accessibility = "IconSettings blue")
    @AndroidFindBy(accessibility = "Account Settings")
    private WebElement iconSettings;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    private WebElement drawer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LOG IN\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signInButtonHome")
    private WebElement loginBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIGN UP\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signUpButtonHome")
    private WebElement signUpBtn;

    @PageLoading
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"VIP\"`]")
    @AndroidFindBy(accessibility = "VIP")
    private WebElement vipSection;

    @iOSXCUITFindBy(accessibility = "HelpIcon")
    @AndroidFindBy(accessibility = "Help")
    private WebElement heroLevelHelpBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"" + DESCRIPTION_TEXT_WITH_NO_POINTS + "\")")
    @iOSXCUITFindBy(accessibility = DESCRIPTION_TEXT_WITH_NO_POINTS)
    private WebElement descriptionTextWhenUserHasNoPoints;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Enter phone number\")]/../android.widget.ImageView[@resource-id=\"com.RaceTrac.Common.qa:id/imageGuestInfo\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"REWARDS\"]")
    private WebElement rewardsSectionScreenForUserWithoutPoints;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"REDEEM POINTS\"]/../XCUIElementTypeStaticText[3]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/rewardsPoints")
    private WebElement availablePoints;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"REDEEM POINTS\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/redeemPointsBtn")
    private WebElement redeemPointsBtn;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/couponsHeaderViewAll")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"View All\"]")
    private WebElement viewAllCouponsBtn;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/getFriendBtn")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"GIFT TO A FRIEND\"]")
    private WebElement giftToAFriendBtn;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/carouselNoOffers")
    @iOSXCUITFindBy(accessibility = "empty set detail label")
    private WebElement noCouponsDisplay;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/couponsHeaderTitleGuest")
    @iOSXCUITFindBy(accessibility = "empty set title")
    private WebElement couponsGraciasInfo;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/payWithGiftCardBtn")
    private WebElement payWIthGiftCArdBtn;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.RaceTrac.Common.qa:id/viewPagerCountDots\"]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePageIndicator")
    private List<WebElement> couponsCarousel;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/breakdownSummaryView")
    private WebElement fuelSavingsBtn;
}