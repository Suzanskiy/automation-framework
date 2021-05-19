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
public class ForgotPassPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "text.title")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/top_view")
    private MobileElement textTitle;

    @iOSXCUITFindBy(accessibility = "textfield.email")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/edt_password_reset_Email")
    private MobileElement emailInput;

    @iOSXCUITFindBy(accessibility = "button.reset_password")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/resetpassword_Email_Continue_Btn")
    private MobileElement resetPassBtn;

    @iOSXCUITFindBy(accessibility = "text.description")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/resetDoneTitle")
    private MobileElement completeMsg;

    @iOSXCUITFindBy(accessibility = "DONE")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/resetpasswordDone")
    private MobileElement doneBtn;
}
