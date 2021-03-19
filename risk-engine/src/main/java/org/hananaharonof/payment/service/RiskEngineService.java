package org.hananaharonof.payment.service;

import org.hananaharonof.payment.client.ClientFactory;
import org.hananaharonof.payment.client.PaymentClient;
import org.hananaharonof.payment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiskEngineService {

    private final PaymentClient paymentClient;

    @Autowired
    public RiskEngineService() {
        this.paymentClient = ClientFactory.paymentClient("localhost", 32101);
    }

    public void createPayment(Payment payment) {
        paymentClient.create(payment);
    }

}
