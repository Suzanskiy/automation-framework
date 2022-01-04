package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class NoInternetConnectionPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/internetErrorTitle")
    private WebElement pageInfo;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tryAgainButton")
    private WebElement okBtn;
}
