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
}
