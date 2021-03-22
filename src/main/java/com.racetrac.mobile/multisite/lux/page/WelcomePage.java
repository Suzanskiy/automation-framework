package com.racetrac.mobile.multisite.lux.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Component
public class WelcomePage extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(accessibility = "WelcomeScreenImage")
    private MobileElement welcomeScreenImageHero;
    @AndroidFindBy(accessibility = "WelcomeScreenTitle")
    private MobileElement welcomeScreenTitle;
    @AndroidFindBy(accessibility = "WelcomeScreenDescription")
    private MobileElement welcomeScreenDescription;
    @AndroidFindBy(accessibility = "WelcomeScreenEmailInput")
    private MobileElement emailInput;
    @AndroidFindBy(accessibility = "LoginScreenPasswordInput")
    private MobileElement passInput;
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"ScreenScrollView\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    private MobileElement showPassEye;
    @PageLoading
    @AndroidFindBy(accessibility = "WelcomeScreenContinueButton")
    private MobileElement continueBtn;
    @AndroidFindBy(accessibility = "LoginScreenLoginButton")
    private MobileElement loginBtn;
    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Button\"])[2]")
    private MobileElement forgotPasswordBtn;
    @PageLoading
    @AndroidFindBy(accessibility = "WelcomeScreenSkipButton")
    private MobileElement skipBtn;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"AppText\"])[1]")
    private MobileElement privacyPolicyTitle;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"AppText\"])[2]")
    private MobileElement privacyPolicyLink;
}
