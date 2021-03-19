package org.hananaharonof.payment.repository;

import org.hananaharonof.payment.model.PaymentDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCrudRepository extends CrudRepository<PaymentDao, String> {

}
