package com.mycompany.invoice.web.service.invoice.number;

import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.repository.ICustomerRepository;
import com.mycompany.invoice.web.repository.IInvoiceRepository;
import com.mycompany.invoice.web.service.IInvoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class InvoiceServiceNumber implements IInvoiceService {

    /**
     * ATTRIBUTS
     */
    private IInvoiceRepository invoiceRepository;
    private ICustomerRepository customerRepository;

    /**
     * CONSTRUCTEUR
     */
    @Autowired
    public InvoiceServiceNumber(IInvoiceRepository invoiceRepository, ICustomerRepository customerRepository){

        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;

    }

    /**
     * METHODS
     */
    @Transactional
    public Invoice create(Invoice invoice){

        System.out.println(" ----- InvoiceServiceNumber/create ----- ");

        // Ajout du customer s'il existe avant d'ajouter la facture
        customerRepository.save(invoice.getCustomer());

        // On enregistre la facture
        return invoiceRepository.save(invoice);
    }

    @Override
    public Iterable<Invoice> getListInvoice(){
        System.out.println(" ----- InvoiceServiceNumber/getListInvoice ----- ");
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number){
        System.out.println(" ----- InvoiceServiceNumber/getInvoiceByNumber ----- ");
        return invoiceRepository.findById(number).orElseThrow(
                () -> new NoSuchElementException("Invoice with number " + number + " not found")
        );
    }

    /**
     * GETTERS/SETTERS
     */
    public IInvoiceRepository getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public ICustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}