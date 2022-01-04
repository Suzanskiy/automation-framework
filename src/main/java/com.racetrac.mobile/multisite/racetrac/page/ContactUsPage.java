package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ContactUsPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/contact_close_btn")
    private WebElement closeContactUsPageBtn;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Please tell us\")]")
    private WebElement contactUsPageMainInfo;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Subject\"]")
    private WebElement subjectsDropDown;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/message_edit_text")
    private WebElement messageField;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/send_message_button")
    private WebElement sendMessageBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/call_toll_free")
    private WebElement tollFreeCall;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/jobs_link")
    private WebElement raceTrackJobsLink;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Monday - Friday 8 AM - 6 PM EST\"]")
    private WebElement tollFreeDaysOfWork;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Call Guest Engagement\"]")
    private WebElement callGuestEngagementInfo;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"General\"]")
    private WebElement generalDropDownSubject;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"Store Experience\"]")
    private WebElement storeExperienceDropDownSubject;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"App\"]")
    private WebElement appDropDownSubject;
}
