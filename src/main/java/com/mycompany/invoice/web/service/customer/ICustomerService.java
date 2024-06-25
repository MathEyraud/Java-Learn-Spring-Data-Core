package com.mycompany.invoice.web.service.customer;

import com.mycompany.invoice.web.entity.Customer;
import com.mycompany.invoice.web.repository.ICustomerRepository;

public interface ICustomerService {

    Customer create(Customer customer);
    void setCustomerRepository(ICustomerRepository customerRepository);
    Iterable<Customer> getListCustomer();
    Customer getCustomerByNumber(Long id);

}