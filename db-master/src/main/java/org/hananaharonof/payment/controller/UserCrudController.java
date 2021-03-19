package org.hananaharonof.payment.controller;

import org.hananaharonof.payment.model.User;
import org.hananaharonof.payment.model.UserDao;
import org.hananaharonof.payment.service.CrudService;
import org.hananaharonof.payment.service.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserCrudController extends CrudController<User, UserDao> {

    private final UserCrudService crudService;

    @Autowired
    public UserCrudController(UserCrudService crudService) {
        this.crudService = crudService;
    }

    @Override
    protected CrudService<User, UserDao> crudService() {
        return crudService;
    }
}
