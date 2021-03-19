package org.hananaharonof.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "payment")
@EqualsAndHashCode(callSuper = true)
public class PaymentDao extends BaseDao {

    @Column(name = "amount")
    private Double amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "payee_id")
    private String payeeId;

    @Column(name = "payment_method_id")
    private String paymentMethodId;

}
