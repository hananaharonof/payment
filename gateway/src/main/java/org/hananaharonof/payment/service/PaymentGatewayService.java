package org.hananaharonof.payment.service;

import java.util.Optional;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.hananaharonof.payment.client.ClientFactory;
import org.hananaharonof.payment.client.CrudClient;
import org.hananaharonof.payment.client.PaymentClient;
import org.hananaharonof.payment.kafka.model.KafkaTopic;
import org.hananaharonof.payment.model.Payment;
import org.hananaharonof.payment.service.validator.PaymentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentGatewayService extends GatewayCrudService<Payment> {

    private final KafkaTemplate<String, Payment> kafkaTemplate;
    private final PaymentClient paymentClient;

    @Autowired
    public PaymentGatewayService(KafkaTemplate<String, Payment> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.paymentClient = ClientFactory.paymentClient();
    }

    @Override
    public void create(Payment payment) {
        log.debug("Got new payment to process {}. Starting to process...", payment);
        PaymentValidator.validate(payment);
        log.debug("Payment validation passed. Sending to risk engine...");
        kafkaTemplate.send(KafkaTopic.RISK_ENGINE_IN.getTopicName(), payment);
    }

    @Override
    protected CrudClient<Payment> crudClient() {
        return paymentClient;
    }

    @Override
    protected Consumer<Payment> entityValidator() {
        return PaymentValidator::validate;
    }
}
