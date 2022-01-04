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
public class JoinRacetracRewardsScreen extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/phoneFieldSocial")
    @iOSXCUITFindBy(accessibility = "textfield.phone_number")
    private WebElement phoneInput;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/birthdayFieldSocial")
    @iOSXCUITFindBy(accessibility = "textfield.birthday")
    private WebElement birthdayInput;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/socialNoBtnPhysicalCard")
    @iOSXCUITFindBy(accessibility = "button.no_reward_card")
    private WebElement noBtnPhysicalCard;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/socialYesBtnPhysicalCard")
    @iOSXCUITFindBy(accessibility = "button.have_reward_card")
    private WebElement yesBtnPhysicalCard;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signupSocialButton")
    @iOSXCUITFindBy(accessibility = "button.create_account")
    private WebElement signupSocialButton;
}
