package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.multisite.racetrac.flow.helper.PopupCloserFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosPopupCloserImpl extends BaseFlow implements PopupCloserFlow {

    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    @Autowired
    BecomeFuelVipFlow becomeFuelVipFlow;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;

    @Override
    public void closePopups() {
        if (promotionalOffersFlow.isPromotionalOffersScreenOpened()) {
            promotionalOffersFlow.skipPromotions();
        }
        if (locationRequestFlow.isLocationRequestOpened()) {
            locationRequestFlow.clickContinue();
        }
        if (notificationRequestFlow.isNotificationRequestOpened()) {
            notificationRequestFlow.clickNotNow();
        }
        if (becomeFuelVipFlow.checkAllElementsIsLoaded()) {
            becomeFuelVipFlow.clickNotRightNow();
        }
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
    }

// IOS:    //already registered user: locations - notifications - reward popups - points and tiers
}
