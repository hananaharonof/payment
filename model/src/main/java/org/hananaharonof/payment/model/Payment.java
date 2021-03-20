package org.hananaharonof.payment.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Payment extends BaseDto {

    private double amount;
    private String currency;
    private String userId;
    private String payeeId;
    private String paymentMethodId;
}
