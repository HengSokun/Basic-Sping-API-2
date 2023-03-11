CREATE TABLE customers(
    customer_id SERIAL PRIMARY KEY NOT NULL,
    customer_name varchar(255) NOT NULL ,
    customer_address varchar(255) NOT NULL ,
    customer_phone varchar(20) NOT NULL
);

INSERT INTO customers(customer_name, customer_address, customer_phone)
VALUES ('Sokun Heng', 'Phnom Penh',  '085715256'),
       ('Rinn Ey', 'Battambong',  '012743254'),
       ('Namumu', 'Siem Reap',  '077476734');

CREATE TABLE products(
  product_id SERIAL PRIMARY KEY NOT NULL,
  product_name varchar(255) NOT NULL ,
  product_price FLOAT NOT NULL
);

INSERT INTO products(product_name, product_price)
VALUES ('Cheeseburger', 2.5),
       ('Hot Dog', 1.5),
       ('Pizza', 5.25);


UPDATE customers SET customer_name = 'Beyonder', customer_address = 'Outerversal', customer_phone = 012131
WHERE customer_id = 5
RETURNING *

CREATE TABLE invoices(
     invoice_id SERIAL PRIMARY KEY NOT NULL,
     invoice_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     customer_id INT NOT NULL,
     FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE invoice_detail (
    id SERIAL PRIMARY KEY NOT NULL,
    invoice_id INT NOT NULL,
    product_id INT NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES invoices(invoice_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);