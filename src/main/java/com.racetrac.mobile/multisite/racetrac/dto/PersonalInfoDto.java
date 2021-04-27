package com.racetrac.mobile.multisite.racetrac.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfoDto {
    private String birthday;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Boolean hasEmailSubscription;
}
