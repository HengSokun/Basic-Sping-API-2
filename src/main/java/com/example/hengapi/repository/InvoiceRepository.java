package com.example.hengapi.repository;

import com.example.hengapi.model.Customers;
import com.example.hengapi.model.Invoices;
import com.example.hengapi.model.Products;
import com.example.hengapi.model.request.InvoiceRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InvoiceRepository {

    @Select("SELECT * FROM invoices")
    @Results(
            id = "Mapper",
            value = {
                    @Result(property = "invoiceId", column = "invoice_id"),
                    @Result(property = "invoiceDate", column = "invoice_date"),
                    @Result(property = "customer", column = "customer_id",
                            one = @One(select = "com.example.repository.CustomerRepository.getCustomerById")),
                    @Result(property = "products", column = "invoice_id",
                            many = @Many(select = "com.example.repository.ProductRepository.getProductsByInvoiceId"))
            }
    )
    List<Invoices> getAllInvoices();

    @Select("SELECT * FROM invoice_details ind " +
            """
            INNER JOIN products p ON p.product_id = int.product_id
            WHERE ind.invoice_id = #{invoiceId}
            """)
    @ResultMap("Mapper")
    List<Products> getProductByInvoiceId (@Param("invoiceId") Integer invoiceId);

    @Insert("INSERI INTO invoices (invoice_date, customer_id " +
            "VALUES (#{new.invoice_date}, #{new.customer_id} " +
            "RETURNING invoice_id")
    @ResultMap("Mapper")
    Integer newInvoice(@Param("new")InvoiceRequest invoiceRequest);
}
