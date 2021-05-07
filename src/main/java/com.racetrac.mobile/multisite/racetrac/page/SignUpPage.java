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
    @iOSXCUITFindBy(accessibility = "text.title")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/top_view")
    private MobileElement pageTitle;

    @iOSXCUITFindBy(accessibility = "textfield.email")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_up_user_email_field")
    private MobileElement emailInput;

    @iOSXCUITFindBy(accessibility = "textfield.password")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_up_user_password_field")
    private MobileElement passwordInput;

    @iOSXCUITFindBy(accessibility = "textfield.phone_number")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_up_user_phone_field")
    private MobileElement phoneInput;

    @iOSXCUITFindBy(accessibility = "textfield.birthday")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_up_user_birthday_field")
    private MobileElement birthDayInput;

    @iOSXCUITFindBy(accessibility = "button.create_account")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_up_done_button")
    private MobileElement createAccountBtn;

}
