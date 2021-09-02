package com.racetrac.mobile.multisite.racetrac.dto.responses.punchh.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PunchhRedeemPointsDto {

    Integer user_id;
    String subject;
    String message;
    String gift_reason;
    Integer gift_count;
}
