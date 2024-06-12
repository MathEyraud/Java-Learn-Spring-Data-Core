package com.mycompany.invoice.web.repository.cache;

import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.repository.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class InvoiceRepositoryCache implements IInvoiceRepository {

    /**
     * ATTRIBUTS
     */
    private static List<Invoice> invoices = new ArrayList<>();

    //@Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * METHODS
     */
    private static final class InvoiceRowMapper implements RowMapper<Invoice> {

        // Redéfinir une méthode de l'interface RowMapper.
        @Override
        public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {

            // Création de la nouvelle facture
            Invoice invoice = new Invoice();

            // Ajout des attributs
            invoice.setNumber(String.valueOf(rs.getLong("INVOICE_NUMBER")));
            invoice.setCustomerName(rs.getString("CUSTOMER_NAME"));
            invoice.setOrderNumber(rs.getString("ORDER_NUMBER"));

            return invoice;
        }
    }

    public Invoice create(Invoice invoice){
        this.invoices.add(invoice);
        System.out.println("Cache : Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName() + ".");
        return invoice;
    }

    public List<Invoice> getListInvoice(){

        // On crée des données fictives, car on a pas encore de DB
        Invoice invoice1 = new Invoice();
        invoice1.setNumber("1");
        invoice1.setCustomerName("Customer1");

        Invoice invoice2 = new Invoice();
        invoice2.setNumber("2");
        invoice2.setCustomerName("Customer2");
        invoice2.setOrderNumber("ON_02");

        // On les ajoutes à une liste qu'on va renvoyer
        List<Invoice> listInvoice = new ArrayList<>();
        listInvoice.add(invoice1);
        listInvoice.add(invoice2);

        // On retourne les données
        return listInvoice;
    }

    public Invoice getInvoiceByNumber(String number){

        System.out.println(" ----- InvoiceRepositoryCache/getInvoiceByNumber ----- ");

        // On crée des données fictives, car on a pas encore de DB
        Invoice invoice = new Invoice();
        invoice.setNumber(number);
        invoice.setCustomerName("Customer_1");
        invoice.setOrderNumber("OrderNumber_1");

        // On retourne les données
        return invoice;
    }

    /**
     * GETTERS/SETTERS
     */
    public static List<Invoice> getInvoices() {
        return invoices;
    }

    public static void setInvoices(List<Invoice> invoices) {
        InvoiceRepositoryCache.invoices = invoices;
    }
}
