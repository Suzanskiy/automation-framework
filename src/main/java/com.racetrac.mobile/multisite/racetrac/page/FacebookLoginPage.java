package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FacebookLoginPage extends BaseMobilePage {

    @PageLoading
   @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField")
    private WebElement emailInput;

    @PageLoading
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeSecureTextField")
    private WebElement passInput;

    @PageLoading
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.Button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Log In\"]")
    private WebElement loginBtn;

}
