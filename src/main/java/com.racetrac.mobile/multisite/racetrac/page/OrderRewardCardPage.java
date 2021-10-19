package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class OrderRewardCardPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='Data_FirstName']")
    private MobileElement firstname;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='Data_LastName']")
    private MobileElement lastName;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='EmailAddress']")
    private MobileElement EmailAddress;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='Data_Phone']")
    private MobileElement DataPhone;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='Birthday']")
    private MobileElement Birthday;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"CONTINUE\"]")
    private MobileElement ContinueButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"CANCEL\"]")
    private MobileElement cancelBtn;

}
