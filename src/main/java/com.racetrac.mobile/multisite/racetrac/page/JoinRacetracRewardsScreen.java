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
public class JoinRacetracRewardsScreen extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/phoneFieldSocial")
    @iOSXCUITFindBy(accessibility = "textfield.phone_number")
    private MobileElement phoneInput;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/birthdayFieldSocial")
    @iOSXCUITFindBy(accessibility = "textfield.birthday")
    private MobileElement birthdayInput;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/socialNoBtnPhysicalCard")
    @iOSXCUITFindBy(accessibility = "button.no_reward_card")
    private MobileElement noBtnPhysicalCard;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/socialYesBtnPhysicalCard")
    @iOSXCUITFindBy(accessibility = "button.have_reward_card")
    private MobileElement yesBtnPhysicalCard;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signupSocialButton")
    @iOSXCUITFindBy(accessibility = "button.create_account")
    private MobileElement signupSocialButton;
}
