package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.InputEmailForGiftCouponFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosInputEmailForGiftCouponImpl extends BaseFlow implements InputEmailForGiftCouponFlow {

    @Step
    @Override
    public boolean isInputEmailPopUpOpened() {
        return getInputEmailForGiftCouponPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void enterEmail(CustomerDto customerDto) {
        getInputEmailForGiftCouponPage().getInputEmailField().clear();
        getInputEmailForGiftCouponPage().getInputEmailField().setValue(customerDto.getPersonalInfo().getEmail());
        getInputEmailForGiftCouponPage().getSendBtn().click();
    }

    @Step
    @Override
    public void enterAnotherEmail(String email) {
        getInputEmailForGiftCouponPage().getInputEmailField().clear();
        getInputEmailForGiftCouponPage().getInputEmailField().setValue(email);
        getInputEmailForGiftCouponPage().getSendBtn().click();
    }

}
