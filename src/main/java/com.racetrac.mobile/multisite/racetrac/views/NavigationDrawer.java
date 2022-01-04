package com.racetrac.mobile.multisite.racetrac.views;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class NavigationDrawer extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(accessibility = "Open navigation drawer")
    private WebElement drawer;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/toolbar_icon_home")
    private WebElement drawerFromCouponsPage;
}
