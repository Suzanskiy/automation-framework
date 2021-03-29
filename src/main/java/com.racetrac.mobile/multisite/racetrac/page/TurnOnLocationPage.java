package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TurnOnLocationPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "notNowButton")
    private MobileElement notNowBtn;
    @PageLoading
    @AndroidFindBy(id = "turnOnButton")
    private MobileElement turnOnBtn;
}