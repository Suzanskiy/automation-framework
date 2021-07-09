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
    @iOSXCUITFindBy(accessibility = "1")
    @AndroidFindBy(accessibility = "VIP")
    private MobileElement vipSection;

    @iOSXCUITFindBy(accessibility = "1")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/non_member_learn_more")
    private MobileElement notMemberLearMoreBtn;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuelVIPProgramDetails")
    private MobileElement fuelVIPProgramDetailsSection;
}