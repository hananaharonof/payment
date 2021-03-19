package org.hananaharonof.payment.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.hananaharonof.payment.model.User;

public interface UserClient {

    @RequestLine("GET /user?id={id}")
    User read(@Param("id") String id);

    @RequestLine("POST /user")
    @Headers("Content-Type: application/json")
    void create(User payment);

}

