package org.hananaharonof.payment.service;

import java.util.function.Function;
import org.hananaharonof.payment.mapper.PaymentMapper;
import org.hananaharonof.payment.mapper.PaymentMethodMapper;
import org.hananaharonof.payment.model.Payment;
import org.hananaharonof.payment.model.PaymentDao;
import org.hananaharonof.payment.model.PaymentMethod;
import org.hananaharonof.payment.model.PaymentMethodDao;
import org.hananaharonof.payment.repository.PaymentCrudRepository;
import org.hananaharonof.payment.repository.PaymentMethodCrudRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodCrudService extends CrudService<PaymentMethod, PaymentMethodDao> {

    private static final PaymentMethodMapper PAYMENT_METHOD_MAPPER = Mappers.getMapper(PaymentMethodMapper.class);

    private final PaymentMethodCrudRepository repository;

    @Autowired
    public PaymentMethodCrudService(PaymentMethodCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<PaymentMethodDao, String> repository() {
        return repository;
    }

    @Override
    protected Function<PaymentMethod, PaymentMethodDao> toDao() {
        return PAYMENT_METHOD_MAPPER::toPaymentMethodDao;
    }

    @Override
    protected Function<PaymentMethodDao, PaymentMethod> toDto() {
        return PAYMENT_METHOD_MAPPER::toPaymentMethod;
    }
}
