package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class OrderRewardCardPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='Data_FirstName']")
    private WebElement firstname;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='Data_LastName']")
    private WebElement lastName;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='EmailAddress']")
    private WebElement EmailAddress;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='Data_Phone']")
    private WebElement DataPhone;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='Birthday']")
    private WebElement Birthday;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"CONTINUE\"]")
    private WebElement ContinueButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"CANCEL\"]")
    private WebElement cancelBtn;

}
