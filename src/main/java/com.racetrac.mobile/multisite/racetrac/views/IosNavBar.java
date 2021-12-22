package com.racetrac.mobile.multisite.racetrac.views;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class IosNavBar extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Home")
    private WebElement homeTab;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Stores")
    private WebElement storesTab;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Coupons")
    private WebElement couponsTab;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Cards")
    private WebElement cardsTab;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Inbox")
    private WebElement inboxTab;
}
