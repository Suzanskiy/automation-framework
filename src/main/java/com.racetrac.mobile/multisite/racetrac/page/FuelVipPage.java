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
public class FuelVipPage extends BaseMobilePage {
    @PageLoading
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"VIP\"`]")
    @AndroidFindBy(accessibility = "VIP")
    private MobileElement vipSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LEARN MORE\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/non_member_learn_more")
    private MobileElement notMemberLearMoreBtn;

    @iOSXCUITFindBy(accessibility = "IvanExpired VIP Member")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuelVIPProgramDetails")
    private MobileElement fuelVIPProgramDetailsSection;
}