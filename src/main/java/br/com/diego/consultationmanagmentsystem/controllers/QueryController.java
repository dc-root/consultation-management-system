package br.com.diego.consultationmanagmentsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.diego.consultationmanagmentsystem.service.ServiceGenericInterface;
import br.com.diego.consultationmanagmentsystem.templates.Query;

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