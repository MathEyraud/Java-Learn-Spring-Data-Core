package com.mycompany.invoice.web.repository.invoice.cache;

import com.mycompany.invoice.web.entity.Invoice;
import com.mycompany.invoice.web.repository.IInvoiceRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Override
    public Invoice save(Invoice invoice){
        this.invoices.add(invoice);
        System.out.println("Cache : Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomer().getName() + ".");
        return invoice;
    }

    @Override
    public Iterable<Invoice> findAll(){
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Invoice> findAllById(Iterable<String> strings) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Invoice entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Invoice> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Invoice> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional findById(String number){
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(String s) {
        throw new UnsupportedOperationException();
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
