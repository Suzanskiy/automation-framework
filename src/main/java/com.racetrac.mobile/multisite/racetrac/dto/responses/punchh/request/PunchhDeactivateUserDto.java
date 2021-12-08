package com.racetrac.mobile.multisite.racetrac.dto.responses.punchh.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PunchhDeactivateUserDto {
    Integer user_id;
}
