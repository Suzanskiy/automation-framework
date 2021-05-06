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
public class FistBumpPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Fist bump for creating an account!")
    @AndroidFindBy(id = "1")
    private MobileElement fistBumpTxt;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"GET STARTED\"]")
    @AndroidFindBy(id = "")
    private MobileElement getStartedBtn;
}