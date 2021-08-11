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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"NEXT\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/confirmButton")
    private MobileElement nextBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SAVE\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/confirmButton")
    private MobileElement saveBtn;

    @iOSXCUITFindBy(accessibility = "NavBarBack")
    private MobileElement navigateBackBtn;
}
