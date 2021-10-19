package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UpdatedEmailPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_title_edit_email")
    private MobileElement editEmailText;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/usernameUpdateSuccessEmail")
    private MobileElement EmailField;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/doneButton")
    private MobileElement doneBtn;
}
