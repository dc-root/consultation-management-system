package br.com.diego.consultationmanagmentsystem.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepository<T> extends JpaRepository<T, Long> {}