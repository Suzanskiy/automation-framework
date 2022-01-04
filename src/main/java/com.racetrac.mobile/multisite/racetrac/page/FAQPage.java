package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FAQPage extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How do I earn points?']")
    private WebElement howDoIearnPoints;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Before\")]")
    private WebElement howDoIearnPointsText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='What is a qualifying product?']")
    private WebElement whatIsQualifProduct;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with (@text,\"Inside\")]")
    private WebElement whatIsQualifProductText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='What can I do with my points?']")
    private WebElement whatCanIDoWithPoints;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with (@text,\"You can\")]")
    private WebElement whatCanIDoWithPointsText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Do my points expire?']")
    private WebElement doMyPointsExpire;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Any\")]")
    private WebElement doMyPointsExpireText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='What are the levels?']")
    private WebElement whatAreTheLevels;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"As you\")]")
    private WebElement whatAreTheLevelsText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Does my level expire?']")
    private WebElement doesMyLevelExpire;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Your tier\")]")
    private WebElement doesMyLevelExpireText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How do I redeem coupons?']")
    private WebElement howDoIredeemCoupons;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"All coupons\")]")
    private WebElement howDoIredeemCouponsText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My phone number is not working at the pump.']")
    private WebElement myPhoneNumberIsNotWorking;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Make sure\")]")
    private WebElement myPhoneNumberIsNotWorkingText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How do I add gift cards to the app?']")
    private WebElement howDoIaddGiftCardToTheApp;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Tap on the Gift Card\")]")
    private WebElement howDoIaddGiftCardToTheAppText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How do I pay with an app gift card?']")
    private WebElement howDoIPayWithAnAppGiftcard;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Tap the Pay button\")]")
    private WebElement howDoIPayWithAnAppGiftcardText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How do I check the balance on my gift card?']")
    private WebElement howDoICheckTheBalanceOnMyGiftCard;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Tap the Gift Card button at the bottom of the " +
            "home screen, or tap Pay\")]")
    private WebElement howDoICheckTheBalanceOnMyGiftCardText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How do I deactivate my account?']")
    private WebElement howDoIDeactiveMyAccount;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Please contact\")]")
    private WebElement howDoIDeactiveMyAccountText;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"App FAQ\'s\"]")
    private WebElement AppFAQs;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/contact_us_txt")
    private WebElement ContactUsBtn;
}


