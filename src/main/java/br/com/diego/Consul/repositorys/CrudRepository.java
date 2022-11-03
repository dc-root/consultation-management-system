package br.com.diego.Consul.repositorys;

import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {
    T save(T entity);
    T findById(ID primaryKey);
    List<T> findAll();
    void delete(T entity);
}