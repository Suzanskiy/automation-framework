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
public class EditEmailPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "textfield.new_email")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/user_new_email_field")
    private WebElement newEmailField;

    @iOSXCUITFindBy(accessibility = "button.back")
    @AndroidFindBy(id = "1")
    private WebElement backBtn;
    @PageLoading
    @iOSXCUITFindBy(accessibility = "button.update_email")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/change_email_button")
    private WebElement changeEmailBtn;
}
