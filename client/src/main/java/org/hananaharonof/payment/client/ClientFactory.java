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
    public static final String LOCALHOST = "localhost";
    public static final int DB_MASTER_PORT = 32101;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.findAndRegisterModules();
    }

    public static PaymentClient paymentClient() {
        return ClientFactory.create("payment", PaymentClient.class);
    }

    public static PaymentMethodClient paymentMethodClient() {
        return ClientFactory.create("paymentmethod", PaymentMethodClient.class);
    }

    public static PaymentStatusClient paymentStatusClient() {
        return ClientFactory.create("paymentstatus", PaymentStatusClient.class);
    }

    public static UserClient userClient() {
        return ClientFactory.create("user", UserClient.class);
    }

    private static <T> T create(String path, Class<T> clazz) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder(OBJECT_MAPPER))
                .decoder(new JacksonDecoder(OBJECT_MAPPER))
                .logger(new Slf4jLogger())
                .logLevel(Level.NONE)
                .target(clazz, String.format("http://%s:%d/%s", LOCALHOST, DB_MASTER_PORT, path));
    }

}
