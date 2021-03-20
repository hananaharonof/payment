package org.hananaharonof.payment.repository;

import org.hananaharonof.payment.model.PaymentStatusDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentStatusCrudRepository extends CrudRepository<PaymentStatusDao, String> {

}
