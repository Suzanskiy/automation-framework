package com.racetrac.mobile.multisite.racetrac.dto.responses;

import com.racetrac.mobile.multisite.racetrac.dto.StatusDto;
import com.racetrac.mobile.multisite.racetrac.dto.TokenDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCustomerWithEmailResponseDto {
    TokenDto token;
    StatusDto status;
}
