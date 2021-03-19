package org.hananaharonof.payment.controller;

import org.hananaharonof.payment.service.CrudService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public abstract class CrudController<T, R> {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public T read(@RequestParam("id") String id) {
        return crudService().read(id).orElse(null);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody T body) {
        crudService().create(body);
    }

    protected abstract CrudService<T, R> crudService();

}
