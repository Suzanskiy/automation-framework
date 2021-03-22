package com.racetrac.mobile.util.listeners;

import com.racetrac.mobile.framework.appium.AppiumDriverProvider;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AllureStepLogging implements StepLifecycleListener {

    private static final Logger LOG = LoggerFactory.getLogger(AppiumDriverProvider.class);

    @Override
    public void beforeStepStart(StepResult result) {
        if (!result.getName().startsWith("Assert")) {
            result.setName(StringUtils.capitalize(StringUtils.join(
                    StringUtils.splitByCharacterTypeCamelCase(result.getName()),
                    ' ')));
        }
        List<String> listOfParametrs = result.getParameters().stream().map(p -> String.format("%s=%s", p.getName(), p.getValue())).collect(Collectors.toList());
        LOG.info(result.getName() + " " + listOfParametrs.toString());
    }

    @Override
    public void afterStepStop(StepResult result) {
        if(result.getName().startsWith("Assert failed: ")){
            result.setStatus(Status.FAILED);
        }
    }
}
