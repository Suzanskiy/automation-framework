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
public class SignUpSelectorPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIGN UP WITH EMAIL\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/emailSignupButton")
    private WebElement signUpWithEmailBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/facebookSignupButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Sign up with Facebook\"]")
    private WebElement signUpWithFacebookBtn;
}