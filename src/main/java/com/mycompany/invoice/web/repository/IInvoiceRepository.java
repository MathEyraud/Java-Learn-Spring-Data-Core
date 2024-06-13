package com.mycompany.invoice.web.repository;

import com.mycompany.invoice.web.entity.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IInvoiceRepository extends CrudRepository<Invoice, String> {

    /**
     * AVEC L'UTILISATION DE SPRING DATA JDBC
     * IL N'EST PLUS NECESSAIRE D'AVOIR UN REPOSITORY
     * C'EST L'INTERFACE QUI VA ETENDRE UN CRUD REPOSITORY
     */
    /*
    Invoice create(Invoice invoice);
    List<Invoice> getListInvoice();
    public Invoice getInvoiceByNumber(String number);
     */
}
