package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;


@Component
@Getter

public class GiftcardPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(accessibility = "No Gift Cards")
    private WebElement noGiftCardImage;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/giftCardNewBtnNoCards")
    private WebElement buyNew_button;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/giftCardAddBtnNoCards")
    private WebElement addGiftCard_button;

}
