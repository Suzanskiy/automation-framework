package com.racetrac.mobile.framework;

import javaslang.control.Option;
import javaslang.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHolder {

    private static final Logger LOG = LoggerFactory.getLogger(PropertiesHolder.class);
    private static PropertiesHolder instance;

    private final Properties properties;

    private PropertiesHolder() {
        properties = new Properties();
        load();
    }

    public static PropertiesHolder getInstance() {
        return Option.of(instance).getOrElse(() -> instance = new PropertiesHolder());
    }

    public String getProperty(String key) {
        return Option.of(properties.getProperty(key)).getOrElseThrow(() -> new RuntimeException("Can't find property " + key));
    }

    private void load() {
        InputStream in = PropertiesHolder.class.getClassLoader().getResourceAsStream(Constants.PROPERTY_FILE);
        Try.run(() -> properties.load(in)).orElse(() -> {
            LOG.error("Failed to load build properties file.");
            throw new RuntimeException("Failed to load build properties file.");
        });
    }
}
