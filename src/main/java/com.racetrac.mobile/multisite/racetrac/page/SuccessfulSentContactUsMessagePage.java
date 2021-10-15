package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SuccessfulSentContactUsMessagePage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/contact_close_btn")
    private MobileElement closeSuccessfulContactMessagePageBtn;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Thank you for your feedback!\"]")
    private MobileElement successfulMessage;
}
