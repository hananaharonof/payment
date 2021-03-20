package org.hananaharonof.payment.service;

import java.util.function.Function;
import org.hananaharonof.payment.mapper.PaymentStatusMapper;
import org.hananaharonof.payment.model.PaymentStatus;
import org.hananaharonof.payment.model.PaymentStatusDao;
import org.hananaharonof.payment.repository.PaymentStatusCrudRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentStatusCrudService extends CrudService<PaymentStatus, PaymentStatusDao> {

    private static final PaymentStatusMapper PAYMENT_Status_MAPPER = Mappers.getMapper(PaymentStatusMapper.class);

    private final PaymentStatusCrudRepository repository;

    @Autowired
    public PaymentStatusCrudService(PaymentStatusCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<PaymentStatusDao, String> repository() {
        return repository;
    }

    @Override
    protected Function<PaymentStatus, PaymentStatusDao> toDao() {
        return PAYMENT_Status_MAPPER::toPaymentStatusDao;
    }

    @Override
    protected Function<PaymentStatusDao, PaymentStatus> toDto() {
        return PAYMENT_Status_MAPPER::toPaymentStatus;
    }
}
