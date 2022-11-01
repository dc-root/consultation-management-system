package br.com.diego.consultationmanagmentsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.diego.consultationmanagmentsystem.service.ServiceGenericInterface;
import br.com.diego.consultationmanagmentsystem.templates.Doctor;

import java.util.*;

@RestController
@RequestMapping("/medicos")
public class DoctorController {
    @Autowired
    private ServiceGenericInterface<Doctor> doctorService;

    @GetMapping
    public List<Doctor> List() {
        return doctorService.list();
    }
}