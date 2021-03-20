package org.hananaharonof.payment.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface CrudClient<T> {

    @RequestLine("GET ?id={id}")
    T read(@Param("id") String id);

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(T item);

}
