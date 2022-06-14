DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products
(
    id    serial PRIMARY KEY,
    title VARCHAR(255),
    cost  numeric(8, 2)
);

INSERT INTO products (title, cost)
VALUES ('bread', 250.00),
       ('Milk', 80.00),
       ('Orange', 120.00),
       ('Butter', 50.00),
       ('Banana', 60.00);