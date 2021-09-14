package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.impl.android.AndroidInputEmailForGiftCouponImpl;

public interface InputEmailForGiftCouponFlow {

    boolean isInputEmailPopUpOpened();

    void enterEmail(CustomerDto customerDto);

    void enterAnotherEmail(String email);
}
