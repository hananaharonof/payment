package org.hananaharonof.payment.service;

import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.repository.CrudRepository;

public abstract class CrudService<T, R> {

    public Optional<T> read(String id) {
        // TODO: add validations
        Optional<R> dao = repository().findById(id);
        if (dao.isPresent()) {
            return dao.map(toDto());
        }
        return Optional.empty();
    }

    public void create(T item) {
        // TODO: add validations
        repository().save(toDao().apply(item));
    }

    protected abstract CrudRepository<R, String> repository();

    protected abstract Function<T, R> toDao();

    protected abstract Function<R, T> toDto();

}
