package org.hananaharonof.payment.mapper;

import org.hananaharonof.payment.model.User;
import org.hananaharonof.payment.model.UserDao;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDao toUserDao(User user);

    User toUser(UserDao userDao);

}
