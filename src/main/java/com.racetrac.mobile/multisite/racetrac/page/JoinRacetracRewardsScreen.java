package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class JoinRacetracRewardsScreen extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/phoneFieldSocial")
    private MobileElement phoneInput;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/birthdayFieldSocial")
    private MobileElement birthdayInput;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/socialNoBtnPhysicalCard")
    private MobileElement noBtnPhysicalCard;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/socialYesBtnPhysicalCard")
    private MobileElement yesBtnPhysicalCard;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signupSocialButton")
    private MobileElement signupSocialButton;
}
