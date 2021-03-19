package org.hananaharonof.payment.model;

import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@NoArgsConstructor
public class BaseDao {

    @Id
    protected String id;

    public String getId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }

        return id;
    }

}
