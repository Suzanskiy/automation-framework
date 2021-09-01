package com.racetrac.mobile.multisite.racetrac.dto.responses.punchh.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLoginResponseDto {
    PunchhAccessTokenDto access_token;
    PunchhUserResponseDto user;
}
