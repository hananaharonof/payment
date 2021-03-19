package org.hananaharonof.payment.repository;

import org.hananaharonof.payment.model.PaymentDao;
import org.hananaharonof.payment.model.UserDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends CrudRepository<UserDao, String> {

}
