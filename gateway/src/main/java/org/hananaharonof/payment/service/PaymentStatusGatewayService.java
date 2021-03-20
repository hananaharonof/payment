package org.hananaharonof.payment.service;

import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.hananaharonof.payment.client.ClientFactory;
import org.hananaharonof.payment.client.CrudClient;
import org.hananaharonof.payment.client.PaymentStatusClient;
import org.hananaharonof.payment.model.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentStatusGatewayService extends GatewayCrudService<PaymentStatus> {

    private final PaymentStatusClient paymentStatusClient;

    @Autowired
    public PaymentStatusGatewayService() {
        this.paymentStatusClient = ClientFactory.paymentStatusClient();
    }

    @Override
    protected CrudClient<PaymentStatus> crudClient() {
        return paymentStatusClient;
    }

    @Override
    protected Consumer<PaymentStatus> entityValidator() {
        return null;
    }
}
