package br.com.diego.Consul.service;

// import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diego.Consul.repositorys.CrudRepository;
import br.com.diego.Consul.templates.Doctor;

import java.util.*;

@Service
public class DoctorServiceImpl implements ServiceGenericInterface<Doctor> {
    @Autowired
    private CrudRepository<Doctor, Long> repository;

    @Override
    public Doctor save(Doctor medico) {
        return repository.save(medico);
    }

    @Override
    public List<Doctor> list() {
        return repository.findAll();
    }

    @Override
    public Doctor search(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void remove(Doctor medico) {
        repository.delete(medico);
    }
}