package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.data.DeepLinks;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.multisite.racetrac.flow.helper.PopupCloserFlow;
import com.racetrac.mobile.util.device.AlertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidPopupCloserImpl extends BaseFlow implements PopupCloserFlow {

    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;

    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;
    CustomerDto customerDto;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    @Autowired
    BecomeFuelVipFlow becomeFuelVipFlow;

    @Override
    public void closePopups() {
        if (promotionalOffersFlow.isPromotionalOffersScreenOpened()) {
            promotionalOffersFlow.skipPromotions();
        }
        locationRequestFlow.clickContinue();
        locationRequestFlow.clickAllowButton();

        if (becomeFuelVipFlow.checkAllElementsIsLoaded()) {
            becomeFuelVipFlow.clickNotRightNow();
        }
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
    }

    // ANDROID: location - rewards - points 15 november
}
