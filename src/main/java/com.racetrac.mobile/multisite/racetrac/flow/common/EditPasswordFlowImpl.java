package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.EditPasswordFlow;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class EditPasswordFlowImpl extends BaseFlow implements EditPasswordFlow {

    @Override
    public CustomerDto editPassword(final CustomerDto customerDto, final String newPassword) {
        String currentPassword = customerDto.getEmailAuth().getPassword();

        enterCurrentPassword(currentPassword);
        getEditPasswordPage().getNewPassword().click();
        enterNewPassword(newPassword);
        getEditPasswordPage().getReEnterPassword().click();
        reEnterNewPassword(newPassword);
        getEditPasswordPage().getNewPasswordEye().click();

        if (getEditPasswordPage().getChangePasswordBtn().isEnabled()) {
            clickChangePasswordBtn();
        }

        customerDto.getEmailAuth().setPassword(newPassword);

        return customerDto;
    }

    @Step
    private void clickChangePasswordBtn() {
        getEditPasswordPage().getChangePasswordBtn().click();
    }

    @Step
    private void reEnterNewPassword(final String newPassword) {
        getEditPasswordPage().getReEnterPassword().sendKeys(newPassword);
    }

    @Step
    private void enterNewPassword(final String newPassword) {
        getEditPasswordPage().getNewPassword().sendKeys(newPassword);
    }

    @Step
    private void enterCurrentPassword(final String password) {
        getEditPasswordPage().getCurrentPassword().sendKeys(password);
    }
}
