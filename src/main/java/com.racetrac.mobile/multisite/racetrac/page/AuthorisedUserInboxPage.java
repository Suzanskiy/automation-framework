package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AuthorisedUserInboxPage extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/img_Awesome")
    private WebElement thumbUpImage;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tvNoNotificationTitle")
    private WebElement awesome;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tvNoNotificationMsg")
    private WebElement label;

}
