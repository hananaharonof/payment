package org.hananaharonof.payment.risk.evaluator;

import org.hananaharonof.payment.model.Payment;

public interface RiskEvaluator {

    double evaluate(Payment payment);

}
