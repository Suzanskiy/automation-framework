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
public class SignUpPage extends BaseMobilePage {

    @iOSXCUITFindBy(accessibility = "NavBarClose")
    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement closeBtn;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Sign Up")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/top_view")
    private MobileElement pageTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_up_user_email_field")
    private MobileElement emailInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_up_user_password_field")
    private MobileElement passwordInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_up_user_phone_field")
    private MobileElement phoneInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[3]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_up_user_birthday_field")
    private MobileElement birthDayInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CREATE ACCOUNT\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_up_done_button")
    private MobileElement createAccountBtn;

}
