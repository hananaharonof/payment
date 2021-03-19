package org.hananaharonof.payment.controller;

import org.hananaharonof.payment.model.PaymentMethod;
import org.hananaharonof.payment.model.PaymentMethodDao;
import org.hananaharonof.payment.service.CrudService;
import org.hananaharonof.payment.service.PaymentMethodCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentmethod")
public class PaymentMethodCrudController extends CrudController<PaymentMethod, PaymentMethodDao> {

    private final PaymentMethodCrudService crudService;

    @Autowired
    public PaymentMethodCrudController(PaymentMethodCrudService crudService) {
        this.crudService = crudService;
    }

    @Override
    protected CrudService<PaymentMethod, PaymentMethodDao> crudService() {
        return crudService;
    }
}
