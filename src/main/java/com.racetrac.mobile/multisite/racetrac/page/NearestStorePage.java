package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;


@Component
@Getter

public class NearestStorePage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/store_detail_store_name")
    private WebElement storeName;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/store_item_row_container")
    private WebElement cityAndDistance;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/store_phone_num")
    private WebElement telephoneNumber;

}
