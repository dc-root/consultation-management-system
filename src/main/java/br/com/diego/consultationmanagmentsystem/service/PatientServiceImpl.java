package br.com.diego.consultationmanagmentsystem.service;

// import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diego.consultationmanagmentsystem.repositorys.CrudRepository;
import br.com.diego.consultationmanagmentsystem.templates.Patient;

import java.util.*;

@Service
public class PatientServiceImpl implements ServiceGenericInterface<Patient> {
    @Autowired
    private CrudRepository<Patient> repository;

    @Override
    public Patient save(Patient paciente) {
        return repository.save(paciente);
    }

    @Override
    public List<Patient> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Patient> search(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void remove(Patient paciente) {
        repository.delete(paciente);
    }
}