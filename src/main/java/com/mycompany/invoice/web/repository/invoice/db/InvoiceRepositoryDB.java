package com.mycompany.invoice.web.repository.invoice.db;

/**
 * AVEC L'UTILISATION DE SPRING DATA JDBC
 * IL N'EST PLUS NECESSAIRE D'AVCOIR UN REPOSITORY
 * C'EST L'INTERFACE QUI VA ETENDRE UN CRUD REPOSITORY
 */

//import com.mycompany.invoice.web.entity.Invoice;
//import com.mycompany.invoice.web.repository.IInvoiceRepository;
//import com.mycompany.invoice.web.repository.cache.InvoiceRepositoryCache;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class InvoiceRepositoryDB implements IInvoiceRepository {
//
//    /**
//     * ATTRIBUTS
//     */
//    private static List<Invoice> invoices = new ArrayList<>();
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    /**
//     * METHODS
//     */
//    private static final class InvoiceRowMapper implements RowMapper<Invoice> {
//
//        // Redéfinir une méthode de l'interface RowMapper.
//        @Override
//        public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//            // Création de la nouvelle facture
//            Invoice invoice = new Invoice();
//
//            // Ajout des attributs
//            invoice.setNumber(String.valueOf(rs.getLong("INVOICE_NUMBER")));
//            invoice.setCustomerName(rs.getString("CUSTOMER_NAME"));
//            invoice.setOrderNumber(rs.getString("ORDER_NUMBER"));
//
//            return invoice;
//        }
//    }
//
//    // Sans DB
//    /*public void create(Invoice invoice){
//        this.invoices.add(invoice);
//        System.out.println("DB : Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName() + ".");
//    }*/
//
//    // Avec DB Sans clé générée pas la DB en retour
//    /*@Override
//    public void create(Invoice invoice){
//        String sql = "INSERT INTO invoice (customer_name, order_number) VALUES (?, ?)";
//        jdbcTemplate.update(sql, invoice.getCustomerName(), invoice.getOrderNumber());
//    }*/
//
//    // Avec DB Avec clé générée par la DB en retour
//    @Override
//    public Invoice create(Invoice invoice) {
//
//        // KeyHolder est utilisé pour capturer la clé générée par la base de données
//        KeyHolder kh = new GeneratedKeyHolder();
//
//        // Utilisation de JdbcTemplate pour exécuter une mise à jour (insertion)
//        jdbcTemplate.update(connection -> {
//
//            // Préparation de la requête SQL avec RETURN_GENERATED_KEYS pour obtenir la clé générée
//            PreparedStatement ps = connection.prepareStatement(
//                    "INSERT INTO INVOICE(CUSTOMER_NAME, ORDER_NUMBER) VALUES (?, ?)",
//                    Statement.RETURN_GENERATED_KEYS
//            );
//            // Affectation des valeurs des paramètres à la requête préparée
//            ps.setString(1, invoice.getCustomerName()); // Premier paramètre (index 1)
//            ps.setString(2, invoice.getOrderNumber());  // Deuxième paramètre (index 2)
//
//            // Retourne l'objet PreparedStatement pour l'exécution
//            return ps;
//
//        }, kh); // KeyHolder pour capturer la clé générée
//
//        // Conversion de la clé générée en chaîne de caractères et l'affecte à l'attribut 'number' de l'objet Invoice
//        invoice.setNumber(kh.getKey().toString());
//
//        // Retourne l'objet Invoice mis à jour avec la clé générée
//        return invoice;
//    }
//
//    // Méthode sans DB
//    /*public List<Invoice> getListInvoice(){
//
//        // On crée des données fictives, car on a pas encore de DB
//        Invoice invoice1 = new Invoice();
//        invoice1.setNumber("1");
//        invoice1.setCustomerName("Customer1");
//
//        Invoice invoice2 = new Invoice();
//        invoice2.setNumber("2");
//        invoice2.setCustomerName("Customer2");
//
//        // On les ajoutes à une liste qu'on va renvoyer
//        List<Invoice> listInvoice = new ArrayList<>();
//        listInvoice.add(invoice1);
//        listInvoice.add(invoice2);
//
//        // On retourne les données
//        return listInvoice;
//    }*/
//
//    // Méthode avec DB
//    @Override
//    public List<Invoice> getListInvoice(){
//
//        System.out.println(" ----- InvoiceRepositoryDB/getListInvoice ----- ");
//
//        // Requête SQL
//        String sqlRequest = "SELECT * FROM invoice";
//        return jdbcTemplate.query(sqlRequest,new InvoiceRowMapper());
//    }
//
//    // Méthode sans DB
//    /*public Invoice getInvoiceByNumber(String number){
//
//        System.out.println(" ----- InvoiceRepositoryDB/getInvoiceByNumber ----- ");
//
//        // On crée des données fictives, car on a pas encore de DB
//        Invoice invoice = new Invoice();
//        invoice.setNumber(number);
//        invoice.setCustomerName("Customer_1");
//        invoice.setOrderNumber("OrderNumber_1");
//
//        // On retourne les données
//        return invoice;
//    }*/
//
//    // Méthode avec DB
//    @Override
//    public Invoice getInvoiceByNumber(String number){
//
//        System.out.println(" ----- InvoiceRepositoryDB/getInvoiceByNumber ----- ");
//
//        // Requête SQL
//        String sqlRequest = "SELECT * FROM invoice WHERE INVOICE_NUMBER=?";
//
//        // On retourne les données
//        return jdbcTemplate.queryForObject(sqlRequest,new InvoiceRowMapper(), number);
//    }
//
//    /**
//     * GETTERS/SETTERS
//     */
//    public static List<Invoice> getInvoices() {
//        return invoices;
//    }
//
//    public static void setInvoices(List<Invoice> invoices) {
//        InvoiceRepositoryDB.invoices = invoices;
//    }
//}