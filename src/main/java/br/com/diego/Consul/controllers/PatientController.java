package br.com.diego.Consul.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.diego.Consul.service.ServiceGenericInterface;
import br.com.diego.Consul.templates.Patient;

import java.util.*;

@RestController
@RequestMapping("/pacientes")
public class PatientController {
    @Autowired
    private ServiceGenericInterface<Patient> patientService;

    @GetMapping
    public List<Patient> List() {
        return patientService.list();
    }
}