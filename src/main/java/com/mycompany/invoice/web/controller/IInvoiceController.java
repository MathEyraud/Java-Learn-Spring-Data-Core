package com.mycompany.invoice.web.controller;

import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.service.IInvoiceService;
import org.springframework.ui.Model;

public interface IInvoiceController {
    String createInvoice(Invoice invoice, Model model);
    void setInvoiceService(IInvoiceService invoiceService);
}
