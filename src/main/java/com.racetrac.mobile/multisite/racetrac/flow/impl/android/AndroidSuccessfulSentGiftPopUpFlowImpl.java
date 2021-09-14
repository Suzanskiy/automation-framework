package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SuccessfulSentGiftPopUpFlow;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AndroidSuccessfulSentGiftPopUpFlowImpl extends BaseFlow implements SuccessfulSentGiftPopUpFlow {
    @Override
    public boolean isSuccessfulSentGiftPopUpOpened() {
        return getSuccessfulSentGiftPopUpPage().waitUntilIsOpened();
    }

    @Override
    public void clickOnSuccessfulSentGiftPopUpOkBtn() {
        getSuccessfulSentGiftPopUpPage().getOkBtn().click();
    }
}
