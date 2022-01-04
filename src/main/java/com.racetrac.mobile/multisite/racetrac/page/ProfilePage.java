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
public class ProfilePage extends BaseMobilePage {

    @iOSXCUITFindBy(accessibility = "button.back")
    @AndroidFindBy(id = "1")
    private WebElement buttonBack;
    @PageLoading
    @iOSXCUITFindBy(accessibility = "textfield.birthday")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/edit_user_birthday_field")
    private WebElement birthDay;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "button.edit_password")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/edit_password")
    private WebElement editPasswordBtn;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "button.edit_email")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/edit_email_button")
    private WebElement editEmailBtn;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "button.save")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/save_profile_button")
    private WebElement buttonSave;
}
