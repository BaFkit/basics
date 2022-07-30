DROP TABLE IF EXISTS products CASCADE;
create table categories
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255)
);

INSERT INTO categories (title)
VALUES ('Grocery'),
       ('Beverages'),
       ('fruits'),
       ('Vegetables');


create table products
(
    id            bigserial PRIMARY KEY,
    title         VARCHAR(255),
    cost          numeric(8, 2),
    category_id   bigserial not null references categories (id),
    created_at    timestamp default current_timestamp,
    updated_at    timestamp default current_timestamp
);

INSERT INTO products (title, cost, category_id)
VALUES ('bread', 250.00, 1),
       ('Milk', 80.00, 2),
       ('Orange', 120.00, 3),
       ('Butter', 50.00, 1),
       ('Salt', 5.00, 1),
       ('Сarrot', 30.00, 4),
       ('Grape', 75.00, 3),
       ('Sauce', 55.00, 2),
       ('Cabbage', 33.00, 4),
       ('Strawberry', 135.00, 3),
       ('Wine', 150.00, 2),
       ('Juice', 40.00, 2),
       ('Banana', 60.00, 3);

create table orders
(
    id          bigserial primary key,
    username    varchar(255) not null,
    total_price int    not null,
    address     varchar(255),
    phone       varchar(255),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

create table order_items
(
    id                bigserial primary key,
    product_id        bigint not null references products (id),
    order_id          bigint not null references orders (id),
    quantity          int    not null,
    price_per_product int    not null,
    price             int    not null,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);

insert into orders (username, total_price, address, phone)
values ('bob', 200, 'address', '12345');

insert into order_items (product_id, order_id, quantity, price_per_product, price)
values (1, 1, 2, 100, 200);