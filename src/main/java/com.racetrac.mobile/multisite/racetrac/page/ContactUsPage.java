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
public class ContactUsPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/contact_close_btn")
    private MobileElement closeContactUsPageBtn;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Please tell us\")]")
    private MobileElement contactUsPageMainInfo;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Subject\"]")
    private MobileElement subjectsDropDown;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/message_edit_text")
    private MobileElement messageField;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/send_message_button")
    private MobileElement sendMessageBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/call_toll_free")
    private MobileElement tollFreeCall;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/jobs_link")
    private MobileElement raceTrackJobsLink;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Monday - Friday 8 AM - 6 PM EST\"]")
    private MobileElement tollFreeDaysOfWork;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Call Guest Engagement\"]")
    private MobileElement callGuestEngagementInfo;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"General\"]")
    private MobileElement generalDropDownSubject;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"Store Experience\"]")
    private MobileElement storeExperienceDropDownSubject;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"App\"]")
    private MobileElement appDropDownSubject;
}
