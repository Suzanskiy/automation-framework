package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

public interface SignInFlow {
    void openLoginInPage();

    boolean isLoginPageOpened();

    void authorize(CustomerDto customerDto);

    void clickGotItBtn();
}