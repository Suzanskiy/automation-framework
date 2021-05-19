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
public class LoginPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "textfield.email")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_in_user_email_field")
    private MobileElement emailInput;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_in_user_password_field")
    @iOSXCUITFindBy(accessibility = "textfield.password")
    private MobileElement passwordInput;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_in_done_button")
    @iOSXCUITFindBy(accessibility = "button.sign_in")
    private MobileElement loginBtn;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "button.forgot_password")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_in_user_forgot_password")
    private MobileElement forgotPassBtn;
}
