package com.racetrac.mobile.multisite.racetrac.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CustomerDto {
    private PersonalInfoDto personalInfo;
    private EmailAuthDto emailAuth;
}
