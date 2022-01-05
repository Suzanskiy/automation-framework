package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ContactUsPage extends BaseMobilePage {
  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/contact_close_btn")
  @iOSXCUITFindBy(accessibility = "NavBarBack")
  private WebElement closeContactUsPageBtn;

  @PageLoading
  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Please tell us\")]")
  @iOSXCUITFindBy(
      xpath =
          "Please let us know how we can help. We will respond to your email within 1 business day.")
  private WebElement contactUsPageMainInfo;

  @PageLoading
  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Subject\"]")
  @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
  private WebElement subjectsDropDown;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/message_edit_text")
  @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextView\"")
  private WebElement messageField;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/send_message_button")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SEND\"]")
  private WebElement sendMessageBtn;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/call_toll_free")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Toll-Free: 1-888-636-5589\"]")
  private WebElement tollFreeCall;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/jobs_link")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"RaceTrac Jobs \"]")
  private WebElement raceTrackJobsLink;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Monday - Friday 8 AM - 6 PM EST\"]")
  private WebElement tollFreeDaysOfWork;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Call Guest Engagement\"]")
  private WebElement callGuestEngagementInfo;

  @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"General\"]")
  private WebElement generalDropDownSubject;

  @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"Store Experience\"]")
  private WebElement storeExperienceDropDownSubject;

  @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"App\"]")
  private WebElement appDropDownSubject;
}
