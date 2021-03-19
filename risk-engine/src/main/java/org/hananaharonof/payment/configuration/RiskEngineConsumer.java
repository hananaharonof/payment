package org.hananaharonof.payment.configuration;

import org.hananaharonof.payment.model.Payment;
import org.hananaharonof.payment.service.RiskEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RiskEngineConsumer {

    private final RiskEngineService riskEngineService;

    @Autowired
    public RiskEngineConsumer(RiskEngineService riskEngineService) {
        this.riskEngineService = riskEngineService;
    }

    @KafkaListener(topics = "#{@messageTopics}", groupId = "#{@messageGroup}")
    public void consume(Payment payment){
        riskEngineService.createPayment(payment);
    }

}
