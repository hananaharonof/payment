package org.hananaharonof.payment.service;

import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.hananaharonof.payment.client.ClientFactory;
import org.hananaharonof.payment.client.CrudClient;
import org.hananaharonof.payment.client.UserClient;
import org.hananaharonof.payment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserGatewayService extends GatewayCrudService<User> {

    private final UserClient userClient;

    @Autowired
    public UserGatewayService() {
        this.userClient = ClientFactory.userClient();
    }

    @Override
    protected CrudClient<User> crudClient() {
        return userClient;
    }

    @Override
    protected Consumer<User> entityValidator() {
        return null;
    }
}
