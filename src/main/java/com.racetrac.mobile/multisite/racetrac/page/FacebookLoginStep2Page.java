package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FacebookLoginStep2Page extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.Button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Продолжить') or contains(@name, 'Продовжити') or contains(@name, 'Continue')]")
    private WebElement continueBtn;
}
