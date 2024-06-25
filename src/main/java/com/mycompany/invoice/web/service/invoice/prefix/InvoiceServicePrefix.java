package com.mycompany.invoice.web.service.invoice.prefix;

import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.repository.IInvoiceRepository;
import com.mycompany.invoice.web.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

//@Service
public class InvoiceServicePrefix implements IInvoiceService {

    /**
     * ATTRIBUTS
     */
    //@Value("${invoice.lastNumber}")
    private long lastNumber;

    //@Value("${invoice.prefix}")
    private String prefix;

    private IInvoiceRepository invoiceRepository;

    /**
     * CONSTRUCTEUR
     */
    //@Autowired
    public InvoiceServicePrefix(IInvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    /**
     * METHODS
     */
    @Override
    public Invoice create(Invoice invoice){
        invoice.setNumber(String.valueOf(prefix + ++this.lastNumber));
        return invoiceRepository.save(invoice);
    }

    @Override
    public Iterable<Invoice> getListInvoice(){
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number){
        return invoiceRepository.findById(number).orElseThrow(
                () -> new NoSuchElementException("Invoice with number " + number + " not found")
        );
    }


    /**
     * GETTERS/SETTERS
     */
    public long getLastNumber() {
        return this.lastNumber;
    }

    public void setLastNumber(long lastNumber) {
        this.lastNumber = lastNumber;
    }

    public IInvoiceRepository getInvoiceRepository() {
        return this.invoiceRepository;
    }

    public void setInvoiceRepository(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}