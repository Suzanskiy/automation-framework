package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FuelSavingsVipPage extends BaseMobilePage {

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/vip_detail_back_btn")
    private MobileElement backBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/vipDetailScreenImage")
    private MobileElement image;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/vipDetailScreenTitle")
    private MobileElement title;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/vipDetailScreenDesc")
    private MobileElement description;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/vipDetailScreenSignUpButton")
    private MobileElement signUpBtn;
}
