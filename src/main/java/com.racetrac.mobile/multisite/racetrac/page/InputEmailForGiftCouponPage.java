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
public class InputEmailForGiftCouponPage extends BaseMobilePage {

    private static final String DESCRIPTION_EMAIL_POP_UP_MESSAGE = "Please enter your friend’s email\n" +
            "address below.";

    private static final String DESCRIPTION_NOTE_POP_UP_MESSAGE = "NOTE: The coupon will be removed\n" +
            "from your list once you tap Send.";

    @PageLoading
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"SEND\" AND name == \"SEND\" AND type == \"XCUIElementTypeButton\"")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"SEND\")")
    private MobileElement sendBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/emailInput")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
    private MobileElement inputEmailField;

    @PageLoading
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"" + DESCRIPTION_EMAIL_POP_UP_MESSAGE + "\")")
    @iOSXCUITFindBy(accessibility = "Please enter your friend’s email address below.")
    private MobileElement emailPopUpDescription;

    @PageLoading
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"" + DESCRIPTION_NOTE_POP_UP_MESSAGE + "\")")
    @iOSXCUITFindBy(accessibility = "NOTE: The coupon will be removed from your list once you tap Send.")
    private MobileElement noteDescription;


}
