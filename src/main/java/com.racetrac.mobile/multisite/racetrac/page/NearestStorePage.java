package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;


@Component
@Getter

public class NearestStorePage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/store_detail_store_name")
    private MobileElement storeName;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/store_item_row_container")
    private MobileElement cityAndDistance;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/store_phone_num")
    private MobileElement telephoneNumber;

}
