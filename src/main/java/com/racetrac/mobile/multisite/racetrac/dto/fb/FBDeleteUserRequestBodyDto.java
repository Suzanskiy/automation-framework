package com.racetrac.mobile.multisite.racetrac.dto.fb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FBDeleteUserRequestBodyDto {
    String access_token;
}
