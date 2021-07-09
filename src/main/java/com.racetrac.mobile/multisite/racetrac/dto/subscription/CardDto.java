package com.racetrac.mobile.multisite.racetrac.dto.subscription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
    String bin;
    String brand;
    ExpDto exp;
    String last4;
    String masked;
    String name;
    String token;
}
