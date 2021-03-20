package org.hananaharonof.payment.controller;

import org.hananaharonof.payment.model.User;
import org.hananaharonof.payment.service.GatewayCrudService;
import org.hananaharonof.payment.service.UserGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserGatewayController extends GatewayCrudController<User> {

    private final UserGatewayService service;

    @Autowired
    public UserGatewayController(UserGatewayService service) {
        this.service = service;
    }

    @Override
    protected GatewayCrudService<User> crudService() {
        return service;
    }
}
