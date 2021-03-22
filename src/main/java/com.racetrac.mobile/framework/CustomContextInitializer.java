package com.racetrac.mobile.framework;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class CustomContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(final ConfigurableApplicationContext ctx) {
        final ConfigurableEnvironment environment = ctx.getEnvironment();
        environment.setActiveProfiles(Configuration.getProfile());
    }
}
