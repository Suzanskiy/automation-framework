package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;


@Component
@Getter

public class GiftcardPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(accessibility = "No Gift Cards")
    private MobileElement noGiftCardImage;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/giftCardNewBtnNoCards")
    private MobileElement buyNew_button;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/giftCardAddBtnNoCards")
    private MobileElement addGiftCard_button;

}
