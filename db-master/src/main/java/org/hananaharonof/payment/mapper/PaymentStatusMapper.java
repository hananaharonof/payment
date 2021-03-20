package org.hananaharonof.payment.mapper;

import org.hananaharonof.payment.model.PaymentStatus;
import org.hananaharonof.payment.model.PaymentStatusDao;
import org.mapstruct.Mapper;

@Mapper
public interface PaymentStatusMapper {

    PaymentStatusDao toPaymentStatusDao(PaymentStatus paymentStatus);

    PaymentStatus toPaymentStatus(PaymentStatusDao paymentStatusDao);

}
