package org.hananaharonof.payment.risk.evaluator;

import org.hananaharonof.payment.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PositiveRiskEvaluator implements RiskEvaluator {

    @Override
    public double evaluate(Payment payment) {
        return 0;
    }

}
