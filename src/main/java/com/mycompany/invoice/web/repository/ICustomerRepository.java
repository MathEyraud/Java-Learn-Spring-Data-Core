package com.mycompany.invoice.web.repository;

import com.mycompany.invoice.web.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {

    Iterable<Customer> findAll();
    Optional<Customer> findById(Long id);
}