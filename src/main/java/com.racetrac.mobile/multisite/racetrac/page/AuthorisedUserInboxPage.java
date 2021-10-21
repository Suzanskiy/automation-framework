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
public class AuthorisedUserInboxPage extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/img_Awesome")
    private MobileElement thumbUpImage;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tvNoNotificationTitle")
    private MobileElement awesome;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tvNoNotificationMsg")
    private MobileElement label;

}
