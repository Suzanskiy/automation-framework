package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PromotionalOffersPage extends BaseMobilePage {
    private static final String POP_UP_FIELD = "Please enter your birthday to continue.";

    @PageLoading
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"No\"])[1]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.Button[2]")
    private MobileElement noAlcohol;

    @PageLoading
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"No\"])[2]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.Button[2]")
    private MobileElement noTobacco;

    @PageLoading
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"No\"])[3]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.Button[2]")
    private MobileElement noLottery;

    @PageLoading
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Yes\"])[3]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Alcohol\"]/../android.widget.Button[@resource-id=\"com.RaceTrac.Common.qa:id/yesBtn\"]")
    private MobileElement yesAlcohol;

    @PageLoading
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Yes\"])[3]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Tobacco\"]/../android.widget.Button[@resource-id=\"com.RaceTrac.Common.qa:id/yesBtn\"]")
    private MobileElement YesTobacco;

    @PageLoading
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Yes\"])[3]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Lottery\"]/../android.widget.Button[@resource-id=\"com.RaceTrac.Common.qa:id/yesBtn\"]")
    private MobileElement yesLottery;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"NEXT\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/confirmButton")
    private MobileElement nextBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SAVE\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/confirmButton")
    private MobileElement saveBtn;

    @iOSXCUITFindBy(accessibility = "NavBarBack")
    private MobileElement navigateBackBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/birthdayTextInput")
    private MobileElement enterBirthdayPopUpField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/confirmBirthday")
    private MobileElement okBirthdayPopUpFieldBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CANCEL\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/cancelBirthday")
    private MobileElement cancelBirthdayPopUpFieldBtn;
    
    @iOSXCUITFindBy(accessibility = POP_UP_FIELD)
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"" + POP_UP_FIELD + "\")")
    private MobileElement descriptionText;
}
