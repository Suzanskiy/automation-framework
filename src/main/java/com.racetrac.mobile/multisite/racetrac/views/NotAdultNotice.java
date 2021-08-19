package com.racetrac.mobile.multisite.racetrac.views;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class NotAdultNotice extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Notice")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/dialogHeader")
    private MobileElement dialogHeader;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "You must be 21 or older to participate.")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/dialogSubtitle")
    private MobileElement subtitle;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/ok_button")
    private MobileElement okButton;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/checkBirthday")
    private MobileElement checkBirthdayBtn;
}
