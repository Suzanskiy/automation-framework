package com.racetrac.mobile.util.attachments;


import com.racetrac.mobile.framework.appium.AppiumDriverProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import io.qameta.allure.Attachment;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

public class Attachments {

	private static final Logger LOG = LoggerFactory.getLogger(AppiumDriverProvider.class);

	@Attachment(value = "Page screenshot", type = "image/png")
	public static byte[] saveScreenshotPNG() {
		LOG.info("Attach screenshot");
		if (getDriver() != null) {
			return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
		} else
			throw new RuntimeException("Driver not created for taking screenshot");
	}

	@Attachment
	public static String attachSourceCode() {
		LOG.info("Attach page source");
		return getDriver().getPageSource();
	}

}
