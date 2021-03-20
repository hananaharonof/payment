package org.hananaharonof.payment.model;

import java.io.Serializable;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseDto implements Serializable {

    protected String id;

    public String getId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }

        return id;
    }
}
