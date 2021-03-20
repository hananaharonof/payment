package org.hananaharonof.payment.service.validator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hananaharonof.payment.exception.BadRequestException;

@Slf4j
public class IdValidator {

    public static void validateId(String id) {
        if (StringUtils.isBlank(id)) {
            log.error("Failed to validate id. Blank id");
            throw new BadRequestException("Blank id");
        }
    }

}
