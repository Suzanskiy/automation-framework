package com.racetrac.mobile.multisite.racetrac.views;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ErrorMessageVIew extends BaseMobilePage {

    @PageLoading
    // @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name=\"This email is already linked to an existing account! Try using another email address.\"]")
    @iOSXCUITFindBy(className = "XCUIElementTypeAlert")
    @AndroidFindBy(id = "android:id/message")
    private WebElement errorMessage;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Ok")
    @AndroidFindBy(id = "android:id/button1")
    private WebElement okButton;
}
