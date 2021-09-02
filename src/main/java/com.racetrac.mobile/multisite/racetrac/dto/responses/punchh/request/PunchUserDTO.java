package com.racetrac.mobile.multisite.racetrac.dto.responses.punchh.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PunchUserDTO {
    String email;
    String password;
}
