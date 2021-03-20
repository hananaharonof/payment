package org.hananaharonof.payment.controller;

import org.hananaharonof.payment.model.PaymentMethod;
import org.hananaharonof.payment.service.GatewayCrudService;
import org.hananaharonof.payment.service.PaymentMethodGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentmethod")
public class PaymentMethodGatewayController extends GatewayCrudController<PaymentMethod> {

    private final PaymentMethodGatewayService service;

    @Autowired
    public PaymentMethodGatewayController(PaymentMethodGatewayService service) {
        this.service = service;
    }

    @Override
    protected GatewayCrudService<PaymentMethod> crudService() {
        return service;
    }
}
