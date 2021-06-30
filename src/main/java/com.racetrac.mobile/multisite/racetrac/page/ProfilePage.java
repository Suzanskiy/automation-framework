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
public class ProfilePage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "button.edit_password")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/edit_password")
    private MobileElement editPasswordBtn;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "button.edit_email")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/edit_email")
    private MobileElement editEmailBtn;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "button.save")
    @AndroidFindBy(id = "1")
    private MobileElement buttonSave;
}
