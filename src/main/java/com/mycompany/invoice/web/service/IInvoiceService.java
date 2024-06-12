package com.mycompany.invoice.web.service;

import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.repository.IInvoiceRepository;

import java.util.List;

public interface IInvoiceService{

    Invoice create(Invoice invoice);
    void setInvoiceRepository(IInvoiceRepository invoiceRepository);
    Iterable<Invoice> getListInvoice();
    Invoice getInvoiceByNumber(String number);

}
