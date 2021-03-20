package org.hananaharonof.payment.service;

import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.hananaharonof.payment.client.ClientFactory;
import org.hananaharonof.payment.client.CrudClient;
import org.hananaharonof.payment.client.PaymentMethodClient;
import org.hananaharonof.payment.model.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentMethodGatewayService extends GatewayCrudService<PaymentMethod> {

    private final PaymentMethodClient paymentMethodClient;

    @Autowired
    public PaymentMethodGatewayService() {
        this.paymentMethodClient = ClientFactory.paymentMethodClient();
    }

    @Override
    protected CrudClient<PaymentMethod> crudClient() {
        return paymentMethodClient;
    }

    @Override
    protected Consumer<PaymentMethod> entityValidator() {
        return null;
    }
}
