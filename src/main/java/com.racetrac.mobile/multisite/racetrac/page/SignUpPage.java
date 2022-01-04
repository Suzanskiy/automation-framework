package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SignUpPage extends BaseMobilePage {

    @iOSXCUITFindBy(accessibility = "NavBarClose")
    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement closeBtn;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "text.title")
    @AndroidFindBy(id =
            "com.RaceTrac.Common.qa:id/topView")
    private WebElement pageTitle;

    @iOSXCUITFindBy(accessibility = "textfield.email")
    @AndroidFindBy(id =
            "com.RaceTrac.Common.qa:id/emailField")
    private WebElement emailInput;

    @iOSXCUITFindBy(accessibility = "textfield.password")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/passwordField")
    private WebElement passwordInput;

    @iOSXCUITFindBy(accessibility = "textfield.phone_number")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/phoneField")
    private WebElement phoneInput;

    @iOSXCUITFindBy(accessibility = "textfield.birthday")
    @AndroidFindBy(id =
            "com.RaceTrac.Common.qa:id/birthdayField")
    private WebElement birthDayInput;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/noBtnPhysicalCard")
    @iOSXCUITFindBy(accessibility = "button.no_reward_card")
    private WebElement noCardButton;
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/yesBtnPhysicalCard")
    private WebElement yesCardButton;

    @iOSXCUITFindBy(accessibility = "button.create_account")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signupDoneButton")
    private WebElement createAccountBtn;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/optionemailcheckbox")
    @iOSXCUITFindBy(accessibility = "button.enable_marketing_emails")
    private WebElement receiveEmailsConfirmationBtn;
}
