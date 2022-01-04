package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.data.FAQdataProvider;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.FAQFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.*;


@Profile(ANDROID)
@Component
public class AndroidFAQFlowImpl extends BaseFlow implements FAQFlow {

    @Step
    @Override
    public boolean isFAQpageDisplayed() {
        return getFaqPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void expandLinks() {
        getFaqPage().getHowDoIearnPoints().click();
        swipeUP();
        getFaqPage().getWhatIsQualifProduct().click();
        swipeUP();
        getFaqPage().getWhatCanIDoWithPoints().click();
        swipeUP();
        getFaqPage().getDoMyPointsExpire().click();
        swipeUP();
        getFaqPage().getWhatAreTheLevels().click();
        swipeUP();
        getFaqPage().getDoesMyLevelExpire().click();
        swipeUP();
        getFaqPage().getHowDoIredeemCoupons().click();
        swipeUP();
        getFaqPage().getMyPhoneNumberIsNotWorking().click();
        swipeUP();
        getFaqPage().getHowDoIaddGiftCardToTheApp().click();
        swipeUP();
        getFaqPage().getHowDoIPayWithAnAppGiftcard().click();
        swipeUP();
        getFaqPage().getHowDoICheckTheBalanceOnMyGiftCard().click();
        swipeUP();
        getFaqPage().getHowDoIDeactiveMyAccount().click();
        swipeUP();

        swipeUP();


    }

    @Step
    @Override
    public boolean isContactUsLinkDisplayed() {
        return getFaqPage().getContactUsBtn().isDisplayed();
    }

    @Step
    @Override
    public boolean checkAllItems() {
        boolean a = getFaqPage().getHowDoIearnPointsText().getText().equals(FAQdataProvider.HOW_DO_i_EARN_POINTS);
        boolean b = getFaqPage().getWhatIsQualifProductText().getText().equals(FAQdataProvider.WHAT_IS_A_QUALIFYING_PRODUCT);
        boolean c = getFaqPage().getWhatCanIDoWithPointsText().getText().equals(FAQdataProvider.WHAT_CAN_I_DO_WITH_MY_POINTS);
        boolean d = getFaqPage().getDoMyPointsExpireText().getText().equals(FAQdataProvider.DO_MY_POINTS_EXPIRE);
        swipeUP();
        boolean y = getFaqPage().getWhatAreTheLevelsText().getText().equals(FAQdataProvider.WHAT_ARE_THE_LEVELS);
        swipeUP();

        boolean e = getFaqPage().getDoesMyLevelExpireText().getText().equals(FAQdataProvider.DOES_MY_LEVEL_EXPIRE);
        swipeUP();

        boolean f = getFaqPage().getHowDoIredeemCouponsText().getText().equals(FAQdataProvider.HOW_DO_I_REDEEM_COUPONS);
        swipeUP();

        boolean g = getFaqPage().getMyPhoneNumberIsNotWorkingText().getText().equals(FAQdataProvider.MY_PHONE_NUMBER_IS_NOT_WORKING_AT_THE_PUMP);
        boolean h = getFaqPage().getHowDoIaddGiftCardToTheAppText().getText().equals(FAQdataProvider.HOW_DO_I_ADD_GIFT_CARDS_O_THE_APP);
        boolean i = getFaqPage().getHowDoIPayWithAnAppGiftcardText().getText().equals(FAQdataProvider.HOW_DO_I_PAY_WITH_AN_APP_GIFTCARD);
        boolean j = getFaqPage().getHowDoICheckTheBalanceOnMyGiftCardText().getText().equals(FAQdataProvider.HOW_DO_I_CHECK_THE_BALANCE_OF_MY_CARD);
        boolean z = getFaqPage().getHowDoIDeactiveMyAccountText().getText().equals(FAQdataProvider.HOW_DO_I_DEACTIVE_MY_ACCOUMT);
        return a&&b&&c&&d&&y&&e&&f&&g&&h&&i&&j&&z;

    }
}