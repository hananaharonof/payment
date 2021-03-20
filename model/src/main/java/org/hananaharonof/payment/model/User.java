package org.hananaharonof.payment.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseDto {

    private String name;
    private String lastName;
    private String country;
    private String city;
    private String street;
    private int houseNumber;

}
