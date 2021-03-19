package org.hananaharonof.payment.service;

import java.util.function.Function;
import org.hananaharonof.payment.mapper.UserMapper;
import org.hananaharonof.payment.model.User;
import org.hananaharonof.payment.model.UserDao;
import org.hananaharonof.payment.repository.UserCrudRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCrudService extends CrudService<User, UserDao> {

    private static final UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    private final UserCrudRepository repository;

    @Autowired
    public UserCrudService(UserCrudRepository repository) {
        this.repository = repository;
    }


    @Override
    protected CrudRepository<UserDao, String> repository() {
        return repository;
    }

    @Override
    protected Function<User, UserDao> toDao() {
        return USER_MAPPER::toUserDao;
    }

    @Override
    protected Function<UserDao, User> toDto() {
        return USER_MAPPER::toUser;
    }
}
