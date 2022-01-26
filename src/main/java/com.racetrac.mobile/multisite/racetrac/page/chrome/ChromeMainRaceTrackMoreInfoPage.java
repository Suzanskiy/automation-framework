package com.racetrac.mobile.multisite.racetrac.page.chrome;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;


@Component
@Getter
public class ChromeMainRaceTrackMoreInfoPage extends BaseMobilePage {


    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'https:')]")
    private WebElement URLxpath;

}
