CREATE TABLE customers(
    customer_id SERIAL PRIMARY KEY NOT NULL,
    customer_name varchar(255) NOT NULL ,
    customer_address varchar(255) NOT NULL ,
    customer_phone varchar(20) NOT NULL
);

INSERT INTO customers(customer_name, customer_address, customer_phone)
VALUES ('Sokun Heng', 'Phnom Penh',  '085745256'),
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
       ('Pizza', 4.25);