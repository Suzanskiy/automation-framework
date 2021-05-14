package com.racetrac.mobile.multisite.racetrac.views;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class IosNavBar extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Home")
    private MobileElement homeTab;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Stores")
    private MobileElement storesTab;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Coupons")
    private MobileElement couponsTab;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Cards")
    private MobileElement cardsTab;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Inbox")
    private MobileElement inboxTab;
}
