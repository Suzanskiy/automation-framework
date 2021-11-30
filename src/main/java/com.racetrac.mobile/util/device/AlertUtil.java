package com.racetrac.mobile.util.device;

import io.qameta.allure.Step;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.NoAlertPresentException;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

@Log
public class AlertUtil {

    @Step
    public static void acceptAlert() {
        try {
            getDriver().switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            log.info("No alert is present to accept");
        }
    }

    @Step
    public static void dismissAlert() {
        try {
            getDriver().switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            log.info("No alert is present to dismiss");
        }
    }
}
