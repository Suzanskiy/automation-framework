package com.racetrac.mobile.util.allure;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

public class AllureEnvironmentUtils {

	private static final File ENV_SOURCE = new File("src/main/resources/environment.properties");
	private static final File ENV_DEST = new File("target/allure-results/environment.properties");
	private static final Logger LOG = LoggerFactory.getLogger(AllureEnvironmentUtils.class);

	public static void createEnvironmentProperties() {
		LOG.info("Create environment.properties");
		try (FileOutputStream fos = new FileOutputStream(ENV_SOURCE)) {
			Properties props = new Properties();
			getDriver().getCapabilities().asMap().forEach((key, value) -> props.setProperty(key, value.toString()));
			props.store(fos, "See https://github.com/allure-framework/allure-app/wiki/Environment");

		} catch (IOException e) {
			LOG.info("IO problem when writing allure properties file " + e);
		}
	}

	public static void copyEnvPropToAllureResults() {
		try {
			FileUtils.copyFile(ENV_SOURCE, ENV_DEST);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}