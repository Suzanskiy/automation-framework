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
public class CustomerDto {
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate birthDate;
    private Boolean receivingEmails;
}
