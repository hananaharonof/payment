package org.hananaharonof.payment.repository;

import org.hananaharonof.payment.model.PaymentDao;
import org.hananaharonof.payment.model.PaymentMethodDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodCrudRepository extends CrudRepository<PaymentMethodDao, String> {

}
