package org.hananaharonof.payment.kafka.serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j
public class JavaSerializer<T extends Serializable> implements Serializer<T> {
    @Override
    public byte[] serialize(String topic, T data) {
        try {
            return serialize(data);
        } catch (IOException e) {
            String msg = String.format("Failed to serialize. Got error %s %s", e.getClass().getCanonicalName(), e.getMessage());
            log.error(msg);
            return null;
        }
    }

    private static byte[] serialize(Serializable data) throws IOException {
        try (
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream)) {

            objectOutputStream.writeObject(data);
            return arrayOutputStream.toByteArray();
        }
    }

}