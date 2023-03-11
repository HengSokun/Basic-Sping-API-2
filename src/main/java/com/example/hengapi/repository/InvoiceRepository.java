package com.example.hengapi.repository;

import com.example.hengapi.model.Customers;
import com.example.hengapi.model.Invoices;
import com.example.hengapi.model.Products;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InvoiceRepository {

    @Select("SELECT * FROM invoices")
    @Result(property = "invoiceId", column = "invoice_id")
    @Result(property = "invoiceDate", column = "invoice_date")
    @Result(property = "customer", column = "customer_id", javaType = Customers.class,
            one = @One(select = "com.example.mapper.CustomerRepository.getCustomerById"))
    @Result(property = "products", column = "invoice_id", javaType = Products.class,
            many = @Many(select = "com.example.mapper.ProductRepository.getProductsByInvoiceId"))
    List<Invoices> getAllInvoices();

    @Select("SELECT * FROM invoice_details ind " +
            """
            INNER JOIN products p ON p.product_id = int.product_id
            WHERE ind.invoice_id = #{invoiceId}
            """)
    List<Products> getProductByInvoiceId (@Param("invoiceId") Integer invoiceId);
}
