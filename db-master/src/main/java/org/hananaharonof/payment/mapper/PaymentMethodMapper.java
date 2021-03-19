package org.hananaharonof.payment.mapper;

import org.hananaharonof.payment.model.PaymentMethod;
import org.hananaharonof.payment.model.PaymentMethodDao;
import org.mapstruct.Mapper;

@Mapper
public interface PaymentMethodMapper {

    PaymentMethodDao toPaymentMethodDao(PaymentMethod paymentMethod);

    PaymentMethod toPaymentMethod(PaymentMethodDao paymentMethodDao);

}
