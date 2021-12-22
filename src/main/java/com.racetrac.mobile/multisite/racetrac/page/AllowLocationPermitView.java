package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AllowLocationPermitView extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private WebElement allowBtn;
}
