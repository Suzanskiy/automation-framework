package com.racetrac.mobile.multisite.racetrac.page.safari;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SafariBrowserPage extends BaseMobilePage {
    @PageLoading
    @iOSXCUITFindBy(accessibility = "URL")
    private MobileElement url;

}
