package com.mycompany.invoice.web.repository;

import com.mycompany.invoice.web.entity.Invoice;

import java.util.List;

public interface IInvoiceRepository {

    Invoice create(Invoice invoice);
    List<Invoice> getListInvoice();
    public Invoice getInvoiceByNumber(String number);
}
