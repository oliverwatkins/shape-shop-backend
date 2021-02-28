
alter table orders
    drop foreign key FKhwb4y673okgt2yuvxrdim6yeo;
alter table orders
    drop foreign key FKjp7lhaugpjb7u4su3h2khmnb3;
alter table orders
    drop foreign key FK7w5elqmehyp6yp8di8juemso7;
alter table orders_item
    drop foreign key FKlrqyo8q92lfie02g03gp8l89x;
alter table orders_orders_item
    drop foreign key FKgqnitr53ki3vm9fkbqqe29diy;
alter table orders_orders_item
    drop foreign key FK385398u3vcaocjbjoa74752t6;
alter table product
    drop foreign key FKfq5l3xbmjnklegxpwm1yeodkj;
alter table product_orders_item
    drop foreign key FKs2y46vhbdrw66vxf7sbr5kltc;
alter table product_orders_item
    drop foreign key FK7lfsamtu5ounb2yoybd0m762n;
drop table if exists address;
drop table if exists company;
drop table if exists credit_card;
drop table if exists orders;
drop table if exists orders_item;
drop table if exists orders_orders_item;
drop table if exists product;
drop table if exists product_orders_item;
drop table if exists users;
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
    name varchar(255),
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
    order_id               bigint not null auto_increment,
    order_amout            varchar(255),
    order_date             datetime(6),
    order_delivery_type    integer,
    order_payment_type     integer,
    order_state            integer,
    addressEntity_id       bigint,
    company_id             bigint,
    creditCardEntity_cc_id bigint,
    primary key (order_id)
) engine = InnoDB;
create table orders_item
(
    orders_item_id bigint not null auto_increment,
    order_amount   integer,
    product_id     bigint not null,
    primary key (orders_item_id)
) engine = InnoDB;
create table orders_orders_item
(
    OrderEntity_order_id      bigint not null,
    orderItems_orders_item_id bigint not null
) engine = InnoDB;
create table product
(
    id              bigint not null auto_increment,
    img_filename    varchar(255),
    name            varchar(255),
    price           decimal(19, 2),
    type            varchar(255),
    company_id_test bigint not null,
    primary key (id)
) engine = InnoDB;
create table product_orders_item
(
    ProductEntity_id      bigint not null,
    orders_orders_item_id bigint not null
) engine = InnoDB;
create table users
(
    id       varchar(255) not null,
    password varchar(255) not null,
    role     varchar(255) not null,
    userName varchar(255) not null,
    primary key (id)
) engine = InnoDB;
alter table orders_orders_item
    add constraint UK_efcexm10u0yeqivbstcj53wd1 unique (orderItems_orders_item_id);
alter table product_orders_item
    add constraint UK_r22m1y35d6nc7l20jqdnjdonw unique (orders_orders_item_id);
alter table users
    add constraint UK_mmns67o5v4bfippoqitu4v3t6 unique (userName);
alter table orders
    add constraint FKhwb4y673okgt2yuvxrdim6yeo foreign key (addressEntity_id) references address (id);
alter table orders
    add constraint FKjp7lhaugpjb7u4su3h2khmnb3 foreign key (company_id) references company (id);
alter table orders
    add constraint FK7w5elqmehyp6yp8di8juemso7 foreign key (creditCardEntity_cc_id) references credit_card (cc_id);
alter table orders_item
    add constraint FKlrqyo8q92lfie02g03gp8l89x foreign key (product_id) references product (id);
alter table orders_orders_item
    add constraint FKgqnitr53ki3vm9fkbqqe29diy foreign key (orderItems_orders_item_id) references orders_item (orders_item_id);
alter table orders_orders_item
    add constraint FK385398u3vcaocjbjoa74752t6 foreign key (OrderEntity_order_id) references orders (order_id);
alter table product
    add constraint FKfq5l3xbmjnklegxpwm1yeodkj foreign key (company_id_test) references company (id);
alter table product_orders_item
    add constraint FKs2y46vhbdrw66vxf7sbr5kltc foreign key (orders_orders_item_id) references orders_item (orders_item_id);
alter table product_orders_item
    add constraint FK7lfsamtu5ounb2yoybd0m762n foreign key (ProductEntity_id) references product (id);
alter table orders_item drop foreign key FKlrqyo8q92lfie02g03gp8l89x;
alter table orders_orders_item drop foreign key FKgqnitr53ki3vm9fkbqqe29diy;
alter table orders_orders_item drop foreign key FK385398u3vcaocjbjoa74752t6;
alter table product_orders_item drop foreign key FKs2y46vhbdrw66vxf7sbr5kltc;
alter table product_orders_item drop foreign key FK7lfsamtu5ounb2yoybd0m762n;
drop table if exists orders;
drop table if exists orders_item;
drop table if exists orders_orders_item;
drop table if exists product;
drop table if exists product_orders_item;
create table orders (order_id bigint not null auto_increment, order_amout varchar(255), order_date datetime(6), order_delivery_type integer, order_payment_type integer, order_state integer, primary key (order_id)) engine=InnoDB;
create table orders_item (orders_item_id bigint not null auto_increment, order_amount integer, product_id bigint not null, primary key (orders_item_id)) engine=InnoDB;
create table orders_orders_item (OrderEntity_order_id bigint not null, orderItems_orders_item_id bigint not null) engine=InnoDB;
create table product (id bigint not null auto_increment, name varchar(255), price decimal(19,2), primary key (id)) engine=InnoDB;
create table product_orders_item (ProductEntity_id bigint not null, orders_orders_item_id bigint not null) engine=InnoDB;
alter table orders_orders_item add constraint UK_efcexm10u0yeqivbstcj53wd1 unique (orderItems_orders_item_id);
alter table product_orders_item add constraint UK_r22m1y35d6nc7l20jqdnjdonw unique (orders_orders_item_id);
alter table orders_item add constraint FKlrqyo8q92lfie02g03gp8l89x foreign key (product_id) references product (id);
alter table orders_orders_item add constraint FKgqnitr53ki3vm9fkbqqe29diy foreign key (orderItems_orders_item_id) references orders_item (orders_item_id);
alter table orders_orders_item add constraint FK385398u3vcaocjbjoa74752t6 foreign key (OrderEntity_order_id) references orders (order_id);
alter table product_orders_item add constraint FKs2y46vhbdrw66vxf7sbr5kltc foreign key (orders_orders_item_id) references orders_item (orders_item_id);
alter table product_orders_item add constraint FK7lfsamtu5ounb2yoybd0m762n foreign key (ProductEntity_id) references product (id);
alter table orders_item drop foreign key FKlrqyo8q92lfie02g03gp8l89x;
alter table orders_orders_item drop foreign key FKgqnitr53ki3vm9fkbqqe29diy;
alter table orders_orders_item drop foreign key FK385398u3vcaocjbjoa74752t6;
alter table product_orders_item drop foreign key FKs2y46vhbdrw66vxf7sbr5kltc;
alter table product_orders_item drop foreign key FK7lfsamtu5ounb2yoybd0m762n;
drop table if exists orders;
drop table if exists orders_item;
drop table if exists orders_orders_item;
drop table if exists product;
drop table if exists product_orders_item;
create table orders (order_id bigint not null auto_increment, order_amout varchar(255), order_date datetime(6), order_delivery_type integer, order_payment_type integer, order_state integer, primary key (order_id)) engine=InnoDB;
create table orders_item (orders_item_id bigint not null auto_increment, order_amount integer, product_id bigint not null, primary key (orders_item_id)) engine=InnoDB;
create table orders_orders_item (OrderEntity_order_id bigint not null, orderItems_orders_item_id bigint not null) engine=InnoDB;
create table product (id bigint not null auto_increment, name varchar(255), price decimal(19,2), primary key (id)) engine=InnoDB;
create table product_orders_item (ProductEntity_id bigint not null, orders_orders_item_id bigint not null) engine=InnoDB;
alter table orders_orders_item add constraint UK_efcexm10u0yeqivbstcj53wd1 unique (orderItems_orders_item_id);
alter table product_orders_item add constraint UK_r22m1y35d6nc7l20jqdnjdonw unique (orders_orders_item_id);
alter table orders_item add constraint FKlrqyo8q92lfie02g03gp8l89x foreign key (product_id) references product (id);
alter table orders_orders_item add constraint FKgqnitr53ki3vm9fkbqqe29diy foreign key (orderItems_orders_item_id) references orders_item (orders_item_id);
alter table orders_orders_item add constraint FK385398u3vcaocjbjoa74752t6 foreign key (OrderEntity_order_id) references orders (order_id);
alter table product_orders_item add constraint FKs2y46vhbdrw66vxf7sbr5kltc foreign key (orders_orders_item_id) references orders_item (orders_item_id);
alter table product_orders_item add constraint FK7lfsamtu5ounb2yoybd0m762n foreign key (ProductEntity_id) references product (id);
