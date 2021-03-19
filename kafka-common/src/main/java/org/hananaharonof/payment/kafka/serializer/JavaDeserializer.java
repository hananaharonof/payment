package org.hananaharonof.payment.kafka.serializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

@Slf4j
public class JavaDeserializer<T> implements Deserializer<T> {

    @Override
    @SuppressWarnings("unchecked")
    public T deserialize(String topic, byte[] data) {
        try {
            return deserialize(data);
        } catch (Exception e) {
            String msg = String.format("Failed to deserialize. Got error %s %s", e.getClass().getCanonicalName(), e.getMessage());
            log.error(msg);
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Serializable> T deserialize(byte[] data) throws IOException, ClassNotFoundException {
        try (
                ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            return (T) objectInputStream.readObject();
        }
    }

}