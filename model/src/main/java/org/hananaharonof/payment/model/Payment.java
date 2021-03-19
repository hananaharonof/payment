package org.hananaharonof.payment.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Payment implements Serializable {

    private String id;
    private Double amount;
    private String currency;
    private String userId;
    private String payeeId;
    private String paymentMethodId;

}
