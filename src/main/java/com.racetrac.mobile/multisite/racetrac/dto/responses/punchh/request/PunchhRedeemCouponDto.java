package com.racetrac.mobile.multisite.racetrac.dto.responses.punchh.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PunchhRedeemCouponDto {
    Integer user_id;
    String subject;
    String message;
    String gift_reason;
    Integer redeemable_id;
}
