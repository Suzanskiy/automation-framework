package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FacebookLoginPage extends BaseMobilePage {

    @PageLoading
    @FindBy(id = "m_login_email")
    private WebElement emailInput;

    @PageLoading
    @FindBy(id = "m_login_password")
    private WebElement passInput;

    @PageLoading
    @FindBy(id = "login_password_step_element")
    private WebElement loginBtn;
}
