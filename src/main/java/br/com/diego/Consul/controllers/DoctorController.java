package br.com.diego.Consul.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.diego.Consul.service.ServiceGenericInterface;
import br.com.diego.Consul.templates.Doctor;

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

    @GetMapping("/{id}")
    public Doctor search(@PathVariable(value = "id") Long clientId) {
        return doctorService.search(clientId); // ant. tratar Optional
    }

    @PostMapping("/cadastro")
    public Doctor add(@RequestBody Doctor medico) {
        doctorService.save(medico);
        return medico;
    }
}