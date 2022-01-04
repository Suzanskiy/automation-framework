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
public class FuelVipPage extends BaseMobilePage {
    @PageLoading
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"VIP\"`]")
    @AndroidFindBy(accessibility = "VIP")
    private WebElement vipSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LEARN MORE\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/non_member_learn_more")
    private WebElement notMemberLearMoreBtn;

    @iOSXCUITFindBy(accessibility = "IvanExpired VIP Member")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuelVIPProgramDetails")
    private WebElement fuelVIPProgramDetailsSection;
}