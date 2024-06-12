package com.mycompany.invoice.web.service.number;

import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.repository.IInvoiceRepository;
import com.mycompany.invoice.web.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InvoiceServiceNumber implements IInvoiceService {

    /**
     * ATTRIBUTS
     */
    private IInvoiceRepository invoiceRepository;

    /**
     * CONSTRUCTEUR
     */
    @Autowired
    public InvoiceServiceNumber(IInvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    /**
     * METHODS
     */
    public Invoice create(Invoice invoice){
        System.out.println(" ----- InvoiceServiceNumber/create ----- ");
        System.out.println(" ----- invoice.getNumber : " + invoice.getNumber());
        System.out.println(" ----- invoice.getNumber : " + invoice.getCustomerName());
        System.out.println(" ----- invoice.getOrderNumber : " + invoice.getOrderNumber());

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
}