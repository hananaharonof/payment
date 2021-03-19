package org.hananaharonof.payment.service;

import java.util.Optional;
import java.util.function.Function;
import org.hananaharonof.payment.mapper.PaymentMapper;
import org.hananaharonof.payment.model.Payment;
import org.hananaharonof.payment.model.PaymentDao;
import org.hananaharonof.payment.repository.PaymentCrudRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentCrudService extends CrudService<Payment, PaymentDao> {

    private static final PaymentMapper PAYMENT_MAPPER = Mappers.getMapper(PaymentMapper.class);

    private final PaymentCrudRepository repository;

    @Autowired
    public PaymentCrudService(PaymentCrudRepository repository) {
        this.repository = repository;
    }


    @Override
    protected CrudRepository<PaymentDao, String> repository() {
        return repository;
    }

    @Override
    protected Function<Payment, PaymentDao> toDao() {
        return PAYMENT_MAPPER::toPaymentDao;
    }

    @Override
    protected Function<PaymentDao, Payment> toDto() {
        return PAYMENT_MAPPER::toPayment;
    }
}
