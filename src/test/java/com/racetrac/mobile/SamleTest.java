package com.racetrac.mobile;

import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.swipeUP;

public class SamleTest extends BaseTest {
    @Test
    public void testName() {
        swipeUP();
        test();
    }

    @Step
    public void test() {

    }
}
