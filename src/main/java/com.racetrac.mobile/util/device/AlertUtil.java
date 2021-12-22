package com.racetrac.mobile.util.device;

import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

@Log
public class AlertUtil {

    @Step
    public static void acceptAlert() {
        try {
            AppiumWaitingUtils.waitUntilAlertIsPresent();
            getDriver().switchTo().alert().accept();
        } catch (NoAlertPresentException | TimeoutException e) {
            log.info("No alert is present to accept");
        }
    }

    @Step
    public static void dismissAlert() {
        try {
            AppiumWaitingUtils.waitUntilAlertIsPresent();
            getDriver().switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            log.info("No alert is present to dismiss");
        }
    }
}
