package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FAQPage extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How do I earn points?']")
    private MobileElement howDoIearnPoints;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Before\")]")
    private MobileElement howDoIearnPointsText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='What is a qualifying product?']")
    private MobileElement whatIsQualifProduct;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with (@text,\"Inside\")]")
    private MobileElement whatIsQualifProductText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='What can I do with my points?']")
    private MobileElement whatCanIDoWithPoints;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with (@text,\"You can\")]")
    private MobileElement whatCanIDoWithPointsText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Do my points expire?']")
    private MobileElement doMyPointsExpire;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Any\")]")
    private MobileElement doMyPointsExpireText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='What are the levels?']")
    private MobileElement whatAreTheLevels;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"As you\")]")
    private MobileElement whatAreTheLevelsText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Does my level expire?']")
    private MobileElement doesMyLevelExpire;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Your tier\")]")
    private MobileElement doesMyLevelExpireText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How do I redeem coupons?']")
    private MobileElement howDoIredeemCoupons;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"All coupons\")]")
    private MobileElement howDoIredeemCouponsText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My phone number is not working at the pump.']")
    private MobileElement myPhoneNumberIsNotWorking;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Make sure\")]")
    private MobileElement myPhoneNumberIsNotWorkingText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How do I add gift cards to the app?']")
    private MobileElement howDoIaddGiftCardToTheApp;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Tap on the Gift Card\")]")
    private MobileElement howDoIaddGiftCardToTheAppText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How do I pay with an app gift card?']")
    private MobileElement howDoIPayWithAnAppGiftcard;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Tap the Pay button\")]")
    private MobileElement howDoIPayWithAnAppGiftcardText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How do I check the balance on my gift card?']")
    private MobileElement howDoICheckTheBalanceOnMyGiftCard;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Tap the Gift Card button at the bottom of the " +
            "home screen, or tap Pay\")]")
    private MobileElement howDoICheckTheBalanceOnMyGiftCardText;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How do I deactivate my account?']")
    private MobileElement howDoIDeactiveMyAccount;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,\"Please contact\")]")
    private MobileElement howDoIDeactiveMyAccountText;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"App FAQ\'s\"]")
    private MobileElement AppFAQs;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/contact_us_txt")
    private MobileElement ContactUsBtn;
}


