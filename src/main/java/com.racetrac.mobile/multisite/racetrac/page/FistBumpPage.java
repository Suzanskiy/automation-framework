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

    @iOSXCUITFindBy(accessibility = "Confetti")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/bump_image")
    private MobileElement confetti;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "GET STARTED")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/getStartedButton")
    private MobileElement getStartedBtn;
}