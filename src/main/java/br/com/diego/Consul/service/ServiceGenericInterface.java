package br.com.diego.Consul.service;

import br.com.diego.Consul.templates.Doctor;

import java.util.*;

public interface ServiceGenericInterface<E> {
    E save(E entity);
    List<E> list();
    E search(Long id);
    void remove(E entity);
}