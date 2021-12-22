package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UpdatedEmailPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_title_edit_email")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"text.title\"])[2]")
    private WebElement editEmailText;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/usernameUpdateSuccessEmail")
    private WebElement EmailField;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "button.update_email")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/doneButton")
    private WebElement doneBtn;
}
