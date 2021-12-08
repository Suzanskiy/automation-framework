package com.racetrac.mobile.multisite.racetrac.dto.fb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FBGenerateUserResponseDto {
    String id;
    String access_token;
    String login_url;
    String email;
    String password;
}
