package org.hananaharonof.payment.mapper;

import org.hananaharonof.payment.model.Payment;
import org.hananaharonof.payment.model.PaymentDao;
import org.mapstruct.Mapper;

@Mapper
public interface PaymentMapper {

    PaymentDao toPaymentDao(Payment payment);

    Payment toPayment(PaymentDao paymentDao);

}
