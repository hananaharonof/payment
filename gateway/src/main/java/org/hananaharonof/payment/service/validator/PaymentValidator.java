package org.hananaharonof.payment.service.validator;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hananaharonof.payment.exception.BadRequestException;
import org.hananaharonof.payment.model.Payment;

@Slf4j
public class PaymentValidator {

    public static void validate(Payment payment) {
        Optional<String> result = validateInternal(payment);
        if (result.isEmpty()) {
            return;
        }

        log.error("Failed to validate payment {} due to {}", payment, result.get());
        throw new BadRequestException(result.get());
    }

    private static Optional<String> validateInternal(Payment payment) {
        if (payment == null) {
            return Optional.of("Null payment");
        }

        if (payment.getAmount() <= 0) {
            return Optional.of("Non positive amount");
        }

        if (StringUtils.isBlank(payment.getCurrency())) {
            return Optional.of("Blank currency");
        }

        if (StringUtils.isBlank(payment.getPaymentMethodId())) {
            return Optional.of("Blank payment method id");
        }

        if (StringUtils.isBlank(payment.getUserId())) {
            return Optional.of("Blank user id");
        }

        if (StringUtils.isBlank(payment.getPayeeId())) {
            return Optional.of("Blank payee id");
        }

        if (payment.getPayeeId().equals(payment.getUserId())) {
            return Optional.of("User id must differ from payee id");
        }

        return Optional.empty();
    }
}
