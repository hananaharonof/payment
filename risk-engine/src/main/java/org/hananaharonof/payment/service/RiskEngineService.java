package org.hananaharonof.payment.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.hananaharonof.payment.client.ClientFactory;
import org.hananaharonof.payment.client.PaymentClient;
import org.hananaharonof.payment.client.PaymentStatusClient;
import org.hananaharonof.payment.model.Payment;
import org.hananaharonof.payment.model.PaymentStatus;
import org.hananaharonof.payment.risk.evaluator.RiskEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RiskEngineService {

    private final List<RiskEvaluator> evaluators;
    private final PaymentClient paymentClient;
    private final PaymentStatusClient paymentStatusClient;

    @Autowired
    public RiskEngineService(List<RiskEvaluator> evaluators) {
        this.evaluators = evaluators;
        this.evaluators.sort(Comparator.comparingInt(RiskEvaluator::order));
        this.paymentClient = ClientFactory.paymentClient();
        this.paymentStatusClient = ClientFactory.paymentStatusClient();
    }

    public void createPayment(Payment payment) {
        log.debug("Got new payment {} to process. Starting now...", payment.getId());
        Optional<RiskEvaluator> rejected = evaluators.stream().filter(e -> !e.evaluate(payment)).findAny();

        if (rejected.isPresent()) {
            log.debug("Payment {} was rejected", payment.getId());
        } else {
            log.debug("Payment {} was approved", payment.getId());
        }

        PaymentStatus paymentStatus = new PaymentStatus();
        paymentStatus.setApproved(rejected.isEmpty());
        paymentStatus.setFailedEvaluator(rejected.map(r -> r.getClass().getSimpleName()).orElse(null));
        paymentStatus.setPaymentId(payment.getId());
        paymentStatus.setTimestamp(LocalDateTime.now());

        log.debug("Created payment status {}", paymentStatus);
        paymentStatusClient.create(paymentStatus);
        paymentClient.create(payment);
    }
}
