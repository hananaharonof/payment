package org.hananaharonof.payment.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.hananaharonof.payment.service.GatewayCrudService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class GatewayCrudController<T> {

    @RequestMapping(method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public T read(@RequestParam("id") String id) {
        return crudService().read(id);
    }

    @RequestMapping(method = POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody T item) {
        crudService().create(item);
    }

    protected abstract GatewayCrudService<T> crudService();
}
