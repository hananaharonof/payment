package org.hananaharonof.payment.risk.evaluator;

import org.hananaharonof.payment.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class IFeelLuckyRiskEvaluator implements RiskEvaluator {

    @Override
    public boolean evaluate(Payment payment) {
        return Math.random() <= 0.7;
    }

    @Override
    public int order() {
        return 1;
    }
}
