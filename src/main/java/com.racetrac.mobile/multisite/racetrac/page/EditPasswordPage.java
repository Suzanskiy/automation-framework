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
    @iOSXCUITFindBy(accessibility = "1")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/top_header_edit_password")
    private MobileElement topHeader;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "1")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/currentPasswordField")
    private MobileElement currentPassword;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "1")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/newPasswordField")
    private MobileElement newPassword;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "1")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/reenterNewPasswordField")
    private MobileElement reEnterPassword;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "1")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/changePassword")
    private MobileElement changePasswordBtn;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "1")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show password\"])[1]")
    private MobileElement currentPasswordEye;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "1")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show password\"])[2]")
    private MobileElement newPasswordEye;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "1")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show password\"])[3]")
    private MobileElement reenterPasswordEye;
}
