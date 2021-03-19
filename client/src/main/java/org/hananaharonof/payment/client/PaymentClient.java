package org.hananaharonof.payment.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.hananaharonof.payment.model.Payment;

public interface PaymentClient {

    @RequestLine("GET /payment?id={id}")
    Payment read(@Param("id") String id);


    @RequestLine("POST /payment")
    @Headers("Content-Type: application/json")
    void create(Payment payment);

}
