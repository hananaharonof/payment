package org.hananaharonof.payment.controller;

import org.hananaharonof.payment.model.Payment;
import org.hananaharonof.payment.model.PaymentDao;
import org.hananaharonof.payment.service.CrudService;
import org.hananaharonof.payment.service.PaymentCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentCrudController extends CrudController<Payment, PaymentDao> {

    private final PaymentCrudService crudService;

    @Autowired
    public PaymentCrudController(PaymentCrudService crudService) {
        this.crudService = crudService;
    }

    @Override
    protected CrudService<Payment, PaymentDao> crudService() {
        return crudService;
    }
}
