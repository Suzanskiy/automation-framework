package com.racetrac.mobile.multisite.racetrac.dto.subscription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {
    String programId;
    boolean essentialWorker;
    PaymentMethodDto paymentMethod;
}
