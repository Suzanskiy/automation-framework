package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

public interface FacebookAuthFlow {
    void authorise(CustomerDto customerDto);

    void singInToFacebook();
}
