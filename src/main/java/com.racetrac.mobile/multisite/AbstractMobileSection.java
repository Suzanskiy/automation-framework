package com.racetrac.mobile.multisite;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractMobileSection extends Widget {

    protected AbstractMobileSection(WebElement element) {
        super(element);
        PageFactory.initElements(new AppiumFieldDecorator(element), this);
    }

    public WebElement getWrappedMobileElement() {
        return (WebElement) getWrappedElement();
    }

    public boolean isDisplayed() {
            return this.getWrappedMobileElement().isDisplayed();
    }
}
