package br.com.fiap.checkpoint.repositories;

import br.com.fiap.checkpoint.models.Customer;
import br.com.fiap.checkpoint.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "SELECT * FROM customer WHERE name like %?1%", nativeQuery = true)
    public List<Customer> findAllByName(String name);

    @Query(value = "SELECT * FROM customer WHERE age > 17", nativeQuery = true)
    public List<Customer> findAllByAgeMaiority();
}
