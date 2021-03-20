package org.hananaharonof.payment.controller;

import org.hananaharonof.payment.model.PaymentStatus;
import org.hananaharonof.payment.model.PaymentStatusDao;
import org.hananaharonof.payment.service.CrudService;
import org.hananaharonof.payment.service.PaymentCrudService;
import org.hananaharonof.payment.service.PaymentStatusCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentstatus")
public class PaymentStatusCrudController extends CrudController<PaymentStatus, PaymentStatusDao> {

    private final PaymentStatusCrudService crudService;

    @Autowired
    public PaymentStatusCrudController(PaymentStatusCrudService crudService) {
        this.crudService = crudService;
    }

    @Override
    protected CrudService<PaymentStatus, PaymentStatusDao> crudService() {
        return crudService;
    }
}
