package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SuccessfulSentContactUsMessagePage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/contact_close_btn")
    private WebElement closeSuccessfulContactMessagePageBtn;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Thank you for your feedback!\"]")
    private WebElement successfulMessage;
}
