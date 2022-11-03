package br.com.diego.Consul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import br.com.diego.Consul.templates.Address;
import br.com.diego.Consul.repositorys.CrudRepository;

import java.util.*;

@Service
public class AddresServiceImpl implements ServiceGenericInterface<Address> {
    @Autowired
    private CrudRepository<Address, Long> repository;

    @Override
    public Address save(Address endereco) {
        return repository.save(endereco);
    }

    @Override
    public List<Address> list() {
        return repository.findAll();
    }

    @Override
    public Address search(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void remove(Address endereco) {
        repository.delete(endereco);
    }
}
