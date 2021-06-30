package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class EditPasswordPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "text.title")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/top_header_edit_password")
    private MobileElement topHeader;

    @iOSXCUITFindBy(accessibility = "textfield.current_password")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/currentPasswordField")
    private MobileElement currentPassword;

    @iOSXCUITFindBy(accessibility = "textfield.new_password")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/newPasswordField")
    private MobileElement newPassword;

    @iOSXCUITFindBy(accessibility = "textfield.confirmation_password")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/reenterNewPasswordField")
    private MobileElement reEnterPassword;

    @iOSXCUITFindBy(accessibility = "button.change_password")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/changePassword")
    private MobileElement changePasswordBtn;

    @iOSXCUITFindBy(accessibility = "button.show_current_password")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show password\"])[1]")
    private MobileElement currentPasswordEye;

    @iOSXCUITFindBy(accessibility = "button.show_new_password")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show password\"])[2]")
    private MobileElement newPasswordEye;

    @iOSXCUITFindBy(accessibility = "button.show_confirmation_password")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show password\"])[3]")
    private MobileElement reenterPasswordEye;
}
