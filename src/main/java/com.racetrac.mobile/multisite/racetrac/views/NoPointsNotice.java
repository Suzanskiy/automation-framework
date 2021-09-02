package com.racetrac.mobile.multisite.racetrac.views;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class NoPointsNotice extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(className = "android.widget.TextView")
    private MobileElement subtitleRewardsCatalog;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/buttonOK")
    private MobileElement okButtonRewardCatalog;

}
