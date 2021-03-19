package org.hananaharonof.payment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "payment_method")
@EqualsAndHashCode(callSuper = true)
public class PaymentMethodDao extends BaseDao {

}
