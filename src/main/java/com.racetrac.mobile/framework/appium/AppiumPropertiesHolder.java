package com.racetrac.mobile.framework.appium;

import com.racetrac.mobile.framework.PropertiesHolder;
import javaslang.control.Option;
import javaslang.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

import static com.racetrac.mobile.framework.enums.Exceptions.FAIL_TO_LOAD_PROPERTIES;


public class AppiumPropertiesHolder {

    private static final Logger LOG = LoggerFactory.getLogger(AppiumPropertiesHolder.class);
    private static AppiumPropertiesHolder instance;
    private final Properties properties;

    private AppiumPropertiesHolder() {
        properties = new Properties();
        load();
    }

    public static AppiumPropertiesHolder getInstance() {
        return Option.of(instance).getOrElse(() -> instance = new AppiumPropertiesHolder());
    }

	public String getProperty(String key) {
		return Option.of(properties.getProperty(key)).getOrElse("");
	}

    private void load() {
        InputStream in = PropertiesHolder.class.getClassLoader().getResourceAsStream(AppiumConstants.PROPERTY_FILE);
        Try.run(() -> properties.load(in)).orElse(() -> {
            LOG.error(FAIL_TO_LOAD_PROPERTIES.message);
            throw new RuntimeException(FAIL_TO_LOAD_PROPERTIES.message);
        });
    }
}
