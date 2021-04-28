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
public class AccountPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Account")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_title")
    private MobileElement title;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIGN OUT\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_out_button")
    private MobileElement signOutBtn;
}