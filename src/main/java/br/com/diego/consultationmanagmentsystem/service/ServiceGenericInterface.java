package br.com.diego.consultationmanagmentsystem.service;

import java.util.*;

public interface ServiceGenericInterface<E> {
    E save(E entity);
    List<E> list();
    Optional<E> search(Long id);
    void remove(E entity);
}