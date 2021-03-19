package org.hananaharonof.payment.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.hananaharonof.payment.model.Payment;
import org.hananaharonof.payment.service.PaymentGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class PaymentGatewayController {

    private final PaymentGatewayService paymentGatewayService;

    @Autowired
    public PaymentGatewayController(PaymentGatewayService paymentGatewayService) {
        this.paymentGatewayService = paymentGatewayService;
    }

    @RequestMapping(method = POST, path = "payment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPayment(@RequestBody Payment payment) {
        paymentGatewayService.createPayment(payment);
    }

}
