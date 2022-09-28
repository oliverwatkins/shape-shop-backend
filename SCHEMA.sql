# alter table orders
#     drop foreign key FKhwb4y673okgt2yuvxrdim6yeo;
# alter table orders
#     drop foreign key FKjp7lhaugpjb7u4su3h2khmnb3;
# alter table orders
#     drop foreign key FK7w5elqmehyp6yp8di8juemso7;
# alter table orders_item
#     drop foreign key FKlrqyo8q92lfie02g03gp8l89x;
# alter table orders_item
#     drop foreign key FKruyqb48dne96c3h7ypby8k39i;
# alter table orders_item
#     drop foreign key FKqa7i0ev3xqm2d6t93n9blxef1;
# alter table product
#     drop foreign key FKfq5l3xbmjnklegxpwm1yeodkj;
drop table if exists product_category;
drop table if exists orders_item;
drop table if exists orders;
drop table if exists product;
drop table if exists users;
drop table if exists credit_card;
drop table if exists address;
drop table if exists category;
drop table if exists company;

create table category
(
    cat_id     bigint not null auto_increment,
    name       varchar(255),
    company_id bigint not null,
    primary key (cat_id)
) engine = InnoDB;

create table address
(
    id        bigint not null auto_increment,
    email     varchar(255),
    name      varchar(255),
    postcode  varchar(255),
    street    varchar(255),
    telephone varchar(255),
    primary key (id)
) engine = InnoDB;

create table company
(
    id   bigint not null auto_increment,
    name varchar(255) UNIQUE,
    primary key (id)
) engine = InnoDB;

create table credit_card
(
    cc_id    bigint not null auto_increment,
    exp_date varchar(255),
    name     varchar(255),
    number   varchar(255),
    type     varchar(255),
    primary key (cc_id)
) engine = InnoDB;

create table orders
(
    order_id                 bigint not null auto_increment,
    order_amout              varchar(255),
    order_date               datetime(6),
    order_delivery_type      integer,
    order_payment_type       integer,
    order_state              integer,
    address_entity_id        bigint,
    company_id               bigint,
    credit_card_entity_cc_id bigint,
    primary key (order_id)
) engine = InnoDB;

create table orders_item
(
    orders_item_id bigint not null auto_increment,
    order_amount   integer,
    product_id     bigint not null,
    id             bigint,
    order_id       bigint,
    primary key (orders_item_id)
) engine = InnoDB;

create table product
(
    id           bigint not null auto_increment,
    description  varchar(255),
    img_filename varchar(255),
    name         varchar(255),
    price        decimal(19, 2),
    company_id   bigint not null,
    primary key (id)
) engine = InnoDB;

create table users
(
    id        bigint       not null auto_increment,
    password  varchar(255) not null,
    role      varchar(255) not null,
    user_name varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table product_category
(
    id     bigint not null auto_increment,
    cat_id bigint not null,
    primary key (id)
) engine = InnoDB;


# alter table category
#     drop foreign key FK2twm010w181ypxiegra4o0rgc;
# alter table category
#     add constraint FK2twm010w181ypxiegra4o0rgc foreign key (company_id) references company (id);

alter table users add constraint UK_mmns67o5v4bfippoqitu4v3t6 unique (user_name);


alter table category add constraint fk_category_company foreign key (company_id) references company (id);
alter table orders add constraint fk_orders_address foreign key (address_entity_id) references address (id);
alter table orders add constraint fk_orders_company foreign key (company_id) references company (id);
alter table orders add constraint fk_orders_creditcard foreign key (credit_card_entity_cc_id) references credit_card (cc_id);
alter table orders_item add constraint fk_orderitem_product foreign key (product_id) references product (id);
# alter table orders_item add constraint fk_orderitem_product foreign key (id) references product (id);
alter table orders_item add constraint fk_orderitem_order foreign key (order_id) references orders (order_id);
alter table product add constraint fk_product_company foreign key (company_id) references company (id);
alter table product_category add constraint fk_productcategory_category foreign key (cat_id) references category (cat_id);
alter table product_category add constraint fk_productcategory_product foreign key (id) references product (id);