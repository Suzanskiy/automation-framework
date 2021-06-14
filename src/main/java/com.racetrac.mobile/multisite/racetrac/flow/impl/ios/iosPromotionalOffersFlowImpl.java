package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosPromotionalOffersFlowImpl extends BaseFlow implements PromotionalOffersFlow {

    @Override
    public void chooseNoAlcohol() {
        LOG.warn("Promotional offers is not implemented on iOS");
    }

    @Override
    public void chooseNoTobacco() {
        LOG.warn("Promotional offers is not implemented on iOS");

    }

    @Override
    public void chooseNoLottery() {
        LOG.warn("Promotional offers is not implemented on iOS");
    }

    @Override
    public void clickNextBtn() {
        LOG.warn("Promotional offers is not implemented on iOS");
    }

    @Override
    public void skipPromotions() {
        LOG.warn("Promotional offers is not implemented on iOS");
    }
}