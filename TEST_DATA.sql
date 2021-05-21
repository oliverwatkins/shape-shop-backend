
START TRANSACTION;

DELETE FROM orders_item;
DELETE FROM orders;
DELETE FROM product;
DELETE FROM users;
DELETE FROM credit_card;
DELETE FROM address;
DELETE FROM company;

INSERT INTO company (id, name) VALUES (1, "alpenhof");
INSERT INTO company (id, name) VALUES (2, "higgins");

INSERT INTO address (id, name, street, postcode, telephone, email) VALUES (1, "Jar Jar Binks", "Bluw Lane Hwy 12", "41412", "+(09)928423444", "jj@gmail.com");
INSERT INTO address (id, name, street, postcode, telephone, email) VALUES (2, "Luke Skywalker", "1 Baker st", "62344", "+(09)34534444", "ls@gmail.com");
INSERT INTO address (id, name, street, postcode, telephone, email) VALUES (3, "Darth Vader", null, null, "+(09)42344333", null);

INSERT INTO credit_card (cc_id, number, exp_date, name, type) VALUES (1, "xxx-xxx-xxxx-6345", "22/22", "JJ Binks", "VISA");
INSERT INTO credit_card (cc_id, number, exp_date, name, type) VALUES (2, "xxx-xxx-xxxx-6323", "12/24", "P Leah", "MASTERCARD");

INSERT INTO users (id, user_name, password, role) VALUES (1, "admin", "2C26B46B68FFC68FF99B453C1D30413413422D706483BFA0F98A5E886266E7AE", "ROLE_ADMIN");
INSERT INTO users (id, user_name, password, role) VALUES (2, "user", "2C26B46B68FFC68FF99B453C1D30413413422D706483BFA0F98A5E886266E7AE", "ROLE_USER");
INSERT INTO users (id, user_name, password, role) VALUES (3, "foo", "2C26B46B68FFC68FF99B453C1D30413413422D706483BFA0F98A5E886266E7AE", "ROLE_USER");

INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (1, "Limit Session IPA", 7.50, "main", "beer.png", 2);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (2, "Idaho NE Pale Ale", 4.50, "main", "beer.png", 2);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (3, "Eclipse Black IPA", 3.50, "main", "beer.png", 2);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (4, "NEW Release! Outer Limit Session IPA", 1.50, "main", "beer.png", 2);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (5, "Trailblazer Table Beer", 4.50, "main", "beer.png", 2);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (6, "Escape English Special Bitter", 7.50, "main", "beer.png", 2);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (7, "Peak Seeker IPA", 8.50, "main", "beer.png", 2);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (8, "Pioneer Cream Ale", 4.50, "main", "beer.png", 2);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (9, "Pumpkin Ale", 4.50, "main", "beer.png", 2);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (10, "2L stainless steel growlers", 12.50, "main", "beer.png", 2);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (11, "T-Shirt", 12.50, "main", "beer.png", 2);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (12, "Beer Mats", 12.50, "main", "beer.png", 2);

# // save a few products 2
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (13, "Lachs-Spinat-Lasagne", 10.90, "main", "pizza.png", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (14, "Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree", 4.50, "main", "pizza.png", 1);

INSERT INTO orders (order_id, order_date, order_delivery_type, order_payment_type, company_id, creditCardEntity_cc_id, addressEntity_id)
VALUES (1, 123123123, 1, 1, 1, 1, 1);

INSERT INTO orders_item (order_amount, orders_item_id, product_id) values (2, 1, 1);

COMMIT;


#     OrderItemEntity oi1 = new OrderItemEntity(p1, 99);
# OrderItemEntity oi2 = new OrderItemEntity(p2, 9);
#
# INSERT INTO orders (order_date, order_delivery_type, order_payment_type, company_id, creditCardEntity_cc_id, addressEntity_id)
# VALUES (123123123, "DELIVERY", "CARD", 1, 1, 1);









