package com.racetrac.mobile.multisite.racetrac.page.chrome;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ChromeMainPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    private MobileElement urlBar;

}