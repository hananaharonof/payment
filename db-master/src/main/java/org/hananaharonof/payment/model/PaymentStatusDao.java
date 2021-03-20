package org.hananaharonof.payment.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "payment_status")
@EqualsAndHashCode(callSuper = true)
public class PaymentStatusDao extends BaseDao {

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "approved")
    private boolean approved;

    @Column(name = "failed_evaluator")
    private String failedEvaluator;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}
