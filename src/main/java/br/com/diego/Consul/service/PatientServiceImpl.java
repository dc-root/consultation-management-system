package br.com.diego.Consul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import br.com.diego.Consul.templates.Patient;
import br.com.diego.Consul.repositorys.CrudRepository;

import java.util.*;

@Service
public class PatientServiceImpl implements ServiceGenericInterface<Patient> {
    @Autowired
    private CrudRepository<Patient, Long> repository;

    @Override
    public Patient save(Patient paciente) {
        return repository.save(paciente);
    }

    @Override
    public List<Patient> list() {
        return repository.findAll();
    }

    @Override
    public Patient search(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void remove(Patient paciente) {
        repository.delete(paciente);
    }
}