package com.mycompany.invoice.web.service.prefixinv;

import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.repository.IInvoiceRepository;
import com.mycompany.invoice.web.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

//@Service
public class InvoiceServicePrefixINV implements IInvoiceService {

    /**
     * ATTRIBUTS
     */
    private static long lastNumber=0L;
    private IInvoiceRepository invoiceRepository;

    /**
     * CONSTRUCTEUR
     */
    @Autowired
    public InvoiceServicePrefixINV(IInvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    /**
     * METHODS
     */
    @Override
    public Invoice create(Invoice invoice){
        invoice.setNumber(String.valueOf("INV_" + ++this.lastNumber));
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
    public static long getLastNumber() {
        return lastNumber;
    }

    public static void setLastNumber(long lastNumber) {
        InvoiceServicePrefixINV.lastNumber = lastNumber;
    }

    public IInvoiceRepository getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
}