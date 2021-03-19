package org.hananaharonof.payment.service;

import org.hananaharonof.payment.kafka.model.KafkaTopic;
import org.hananaharonof.payment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayService {

    private final KafkaTemplate<String, Payment> kafkaTemplate;

    @Autowired
    public PaymentGatewayService(KafkaTemplate<String, Payment> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void createPayment(Payment payment) {
        kafkaTemplate.send(KafkaTopic.RISK_ENGINE_IN.getTopicName(), payment);
    }

}
