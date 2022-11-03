package br.com.diego.Consul.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.diego.Consul.service.ServiceGenericInterface;
import br.com.diego.Consul.templates.Query;

import java.util.*;

@RestController
@RequestMapping("/consultas")
public class QueryController {
    @Autowired
    private ServiceGenericInterface<Query> queryService;

    @GetMapping
    public List<Query> List() {
        return queryService.list();
    }
}