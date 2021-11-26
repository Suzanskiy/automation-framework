package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FacebookLoginStep2Page extends BaseMobilePage {

    @PageLoading
    @FindBy(xpath = "//button[contains(@name,'__CONFIRM__')]")
    private WebElement continueBtn;
}
