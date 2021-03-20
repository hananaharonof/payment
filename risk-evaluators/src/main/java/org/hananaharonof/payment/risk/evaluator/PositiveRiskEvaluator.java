package org.hananaharonof.payment.risk.evaluator;

import org.hananaharonof.payment.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PositiveRiskEvaluator implements RiskEvaluator {

    @Override
    public boolean evaluate(Payment payment) {
        return true;
    }

    @Override
    public int order() {
        return 0;
    }
}
