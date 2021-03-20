package org.hananaharonof.payment.service;

import java.util.Optional;
import java.util.function.Consumer;
import org.hananaharonof.payment.client.CrudClient;
import org.hananaharonof.payment.exception.NotFoundException;
import org.hananaharonof.payment.service.validator.IdValidator;

public abstract class GatewayCrudService<T> {

    public T read(String id) {
        IdValidator.validateId(id);
        T result = crudClient().read(id);
        if (result == null) {
            throw new NotFoundException();
        }

        return result;
    }

    public void create(T item) {
        if (entityValidator() != null) {
            entityValidator().accept(item);
        }

        crudClient().create(item);
    }

    protected abstract CrudClient<T> crudClient();

    protected abstract Consumer<T> entityValidator();
}
