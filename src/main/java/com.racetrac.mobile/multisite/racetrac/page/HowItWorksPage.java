package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class HowItWorksPage extends PointsAndLevelsPage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/logo_scan")
    private MobileElement scanLogo;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/logo_scan_desc")
    private MobileElement scanLogoDescription;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/logo_scan_desc")
    private MobileElement earnLogo;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/logo_earn_description")
    private MobileElement earnLogoDescription;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/logo_redeem")
    private MobileElement redeemLogo;


    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/logo_redeem_description")
    private MobileElement redeemLogoDescription;

}
