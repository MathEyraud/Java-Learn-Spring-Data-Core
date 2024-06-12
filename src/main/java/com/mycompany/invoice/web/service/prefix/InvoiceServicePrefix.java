package com.mycompany.invoice.web.service.prefix;

import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.repository.IInvoiceRepository;
import com.mycompany.invoice.web.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return invoiceRepository.create(invoice);
    }

    @Override
    public List<Invoice> getListInvoice(){
        return invoiceRepository.getListInvoice();
    }

    @Override
    public Invoice getInvoiceByNumber(String number){return invoiceRepository.getInvoiceByNumber(number);}


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