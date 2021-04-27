package com.racetrac.mobile.multisite.racetrac.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private PersonalInfoDto personalInfo;
    private EmailAuthDto emailAuth;
}
