package com.mycompany.invoice.web.service.customer;

import com.mycompany.invoice.web.entity.Customer;
import com.mycompany.invoice.web.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerService implements ICustomerService{
    /**
     * ATTRIBUTS
     */
    private ICustomerRepository customerRepository;

    /**
     * CONSTRUCTEUR
     */
    @Autowired
    public CustomerService(ICustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    /**
     * METHODS
     */
    public Customer create(Customer customer){
        System.out.println(" ----- CustomerServiceNumber/create ----- ");
        return customerRepository.save(customer);
    }

    @Override
    public Iterable<Customer> getListCustomer(){
        System.out.println(" ----- CustomerServiceNumber/getListCustomer ----- ");
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByNumber(Long id){
        System.out.println(" ----- CustomerServiceNumber/getCustomerByNumber ----- ");
        return customerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Customer with id " + id + " not found")
        );
    }

    /**
     * GETTERS/SETTERS
     */
    public ICustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
