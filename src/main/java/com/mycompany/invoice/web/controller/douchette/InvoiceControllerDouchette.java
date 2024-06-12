package com.mycompany.invoice.web.controller.douchette;

import com.mycompany.invoice.web.controller.IInvoiceController;
import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

//@Controller
public class InvoiceControllerDouchette implements IInvoiceController {

    /**
     * ATTRIBUTS
     */
    private IInvoiceService invoiceService;

    /**
     * CONSTRUCTEUR
     */
    @Autowired
    public InvoiceControllerDouchette(IInvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    /**
     * METHODS
     */
    @Override
    public String createInvoice(Invoice invoice, Model model){

        invoice.setCustomerName(invoice.getCustomerName());
        invoice.setOrderNumber(invoice.getOrderNumber());

        invoiceService.create(invoice);

        model.addAttribute("message", "Invoice successfully submitted!");

        return "invoice-add-success";
    }

    /**
     * GETTERS/SETTERS
     */
    public IInvoiceService getInvoiceService() {
        return invoiceService;
    }
    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
}