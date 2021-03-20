package org.hananaharonof.payment.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PaymentStatus extends BaseDto {

    private String paymentId;
    private boolean approved;
    private String failedEvaluator;
    private LocalDateTime timestamp;

}
