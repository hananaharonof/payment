package org.hananaharonof.payment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private String id;
    private String name;
    private String lastName;
    private String country;
    private String city;
    private String street;
    private int houseNumber;

}
