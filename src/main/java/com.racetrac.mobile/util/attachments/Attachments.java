package com.racetrac.mobile.util.attachments;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

public class Attachments {

    private static final Logger LOG = LoggerFactory.getLogger(Attachments.class);

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG() {
        LOG.info("Attach screenshot");
        if (getDriver() != null) {
            return getDriver().getScreenshotAs(OutputType.BYTES);
        } else
            throw new RuntimeException("Driver not created for taking screenshot");
    }

    @Attachment
    public static String attachSourceCode() {
        LOG.info("Attach page source");
        return getDriver().getPageSource();
    }

}
