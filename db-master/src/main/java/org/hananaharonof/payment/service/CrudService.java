package org.hananaharonof.payment.service;

import java.util.Optional;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

@Slf4j
public abstract class CrudService<T, R> {

    public Optional<T> read(String id) {
        Optional<R> dao = repository().findById(id);
        if (dao.isPresent()) {
            return dao.map(toDto());
        }
        return Optional.empty();
    }

    public void create(T item) {
        repository().save(toDao().apply(item));
        log.debug("Persisted new item: {}", item);
    }

    protected abstract CrudRepository<R, String> repository();

    protected abstract Function<T, R> toDao();

    protected abstract Function<R, T> toDto();

}
