package com.racetrac.mobile.multisite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractMobileSection extends Widget {

    protected AbstractMobileSection(WebElement element) {
        super(element);
        PageFactory.initElements(new AppiumFieldDecorator(element), this);
    }

    public MobileElement getWrappedMobileElement() {
        return (MobileElement) getWrappedElement();
    }

    public boolean isDisplayed() {
            return this.getWrappedMobileElement().isDisplayed();
    }
}
