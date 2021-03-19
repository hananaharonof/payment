package org.hananaharonof.payment.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.hananaharonof.payment.model.PaymentMethod;

public interface PaymentMethodClient {

    @RequestLine("GET /paymentmethod?id={id}")
    PaymentMethod read(@Param("id") String id);


    @RequestLine("POST /paymentmethod")
    @Headers("Content-Type: application/json")
    void create(PaymentMethod paymentMethod);

}

