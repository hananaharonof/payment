package org.hananaharonof.payment;

import lombok.extern.slf4j.Slf4j;
import org.hananaharonof.payment.service.PaymentCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@EnableJpaRepositories
@SpringBootApplication
public class DbMasterApplication {

    @Autowired
    private PaymentCrudService paymentCrudService;

    public static void main(String[] args) {
        SpringApplication.run(DbMasterApplication.class, args);
    }
}
