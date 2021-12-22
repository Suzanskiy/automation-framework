package com.racetrac.mobile.multisite.racetrac.page.safari;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SafariBrowserPage extends BaseMobilePage {
    @PageLoading
    @iOSXCUITFindBy(accessibility = "URL")
    private WebElement url;

}
