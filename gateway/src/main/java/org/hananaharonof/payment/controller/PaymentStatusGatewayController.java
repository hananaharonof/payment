package org.hananaharonof.payment.controller;

import org.hananaharonof.payment.model.PaymentStatus;
import org.hananaharonof.payment.service.GatewayCrudService;
import org.hananaharonof.payment.service.PaymentStatusGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentStatus")
public class PaymentStatusGatewayController extends GatewayCrudController<PaymentStatus> {

    private final PaymentStatusGatewayService service;

    @Autowired
    public PaymentStatusGatewayController(PaymentStatusGatewayService service) {
        this.service = service;
    }

    @Override
    protected GatewayCrudService<PaymentStatus> crudService() {
        return service;
    }
}
