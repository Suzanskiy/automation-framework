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
    @iOSXCUITFindBy(accessibility = "Edit Password")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/top_header_edit_password")
    private MobileElement topHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField[1]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/currentPasswordField")
    private MobileElement currentPassword;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField[2]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/newPasswordField")
    private MobileElement newPassword;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField[3]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/reenterNewPasswordField")
    private MobileElement reEnterPassword;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CHANGE PASSWORD\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/changePassword")
    private MobileElement changePasswordBtn;

    @iOSXCUITFindBy(xpath =
            "(//XCUIElementTypeButton[@name=\"passwordShow\"])[1]")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show password\"])[1]")
    private MobileElement currentPasswordEye;

    @iOSXCUITFindBy(xpath =
            "(//XCUIElementTypeButton[@name=\"passwordShow\"])[2]")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show password\"])[2]")
    private MobileElement newPasswordEye;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"passwordShow\"])[3]")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show password\"])[3]")
    private MobileElement reenterPasswordEye;
}
