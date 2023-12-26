
create table cart_items
(
    quantity   integer   not null,
    id         bigserial not null,
    product_id bigint,
    primary key (id)
);

create table orders
(
    quantity    integer,
    total_price float(53),
    id          bigserial not null,
    product_id  bigint    not null,
    user_id     bigint    not null,
    primary key (id)
);

create table products
(
    price       integer,
    id          bigserial not null,
    description varchar(255) not null,
    name        varchar(255) not null,
    primary key (id)
);

create table users
(
    age        integer,
    id         bigserial not null,
    email      varchar(255) not null,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    password   varchar(255) not null,
    primary key (id)
);

alter table if exists cart_items add constraint
    cart_item_products_fk foreign key
    (product_id) references products;

alter table if exists orders add constraint
    orders_products_fk foreign key
    (product_id) references products;

alter table if exists orders add constraint
    orders_users_fk foreign key
    (user_id) references users;