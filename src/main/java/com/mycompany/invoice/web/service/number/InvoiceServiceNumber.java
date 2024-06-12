package com.mycompany.invoice.web.service.number;

import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.repository.IInvoiceRepository;
import com.mycompany.invoice.web.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceNumber implements IInvoiceService {

    /**
     * ATTRIBUTS
     */
    private static long lastNumber=0L;
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

        invoice.setNumber(String.valueOf(++this.lastNumber));
        return invoiceRepository.create(invoice);
    }

    @Override
    public List<Invoice> getListInvoice(){
        System.out.println(" ----- InvoiceServiceNumber/getListInvoice ----- ");
        return invoiceRepository.getListInvoice();
    }

    @Override
    public Invoice getInvoiceByNumber(String number){
        System.out.println(" ----- InvoiceServiceNumber/getInvoiceByNumber ----- ");
        return invoiceRepository.getInvoiceByNumber(number);
    }

    /**
     * GETTERS/SETTERS
     */
    public static long getLastNumber() {
        return lastNumber;
    }

    public static void setLastNumber(long lastNumber) {
        InvoiceServiceNumber.lastNumber = lastNumber;
    }

    public IInvoiceRepository getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
}