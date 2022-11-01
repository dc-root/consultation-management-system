package br.com.diego.consultationmanagmentsystem.service;

// import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diego.consultationmanagmentsystem.repositorys.CrudRepository;
import br.com.diego.consultationmanagmentsystem.templates.Query;

import java.util.*;

@Service
public class QueryServiceImpl implements ServiceGenericInterface<Query> {
    @Autowired
    private CrudRepository<Query> repository;

    @Override
    public Query save(Query query) {
        return repository.save(query);
    }

    @Override
    public List<Query> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Query> search(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void remove(Query query) {
        repository.delete(query);
    }
}