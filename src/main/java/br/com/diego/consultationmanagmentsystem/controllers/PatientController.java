package br.com.diego.consultationmanagmentsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.diego.consultationmanagmentsystem.service.ServiceGenericInterface;
import br.com.diego.consultationmanagmentsystem.templates.Patient;

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