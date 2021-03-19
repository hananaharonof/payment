package org.hananaharonof.payment.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger.Level;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class ClientFactory {

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.findAndRegisterModules();
    }

    public static PaymentClient paymentClient(String host, int port) {
        return ClientFactory.create(host, port, PaymentClient.class);
    }

    public static PaymentMethodClient paymentMethodClient(String host, int port) {
        return ClientFactory.create(host, port, PaymentMethodClient.class);
    }

    public static UserClient userClient(String host, int port) {
        return ClientFactory.create(host, port, UserClient.class);
    }

    private static <T> T create(String host, int port, Class<T> clazz) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder(OBJECT_MAPPER))
                .decoder(new JacksonDecoder(OBJECT_MAPPER))
                .logger(new Slf4jLogger())
                .logLevel(Level.NONE)
                .target(clazz, String.format("http://%s:%d/", host, port));
    }

}
