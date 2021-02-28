
INSERT INTO company (name) VALUES ("alpenhof");
INSERT INTO company (name) VALUES ("higgins");

INSERT INTO address (name, street, postcode, telephone, email) VALUES ("Jar Jar Binks", "Bluw Lane Hwy 12", "41412", "+(09)928423444", "jj@gmail.com");
INSERT INTO address (name, street, postcode, telephone, email) VALUES ("Luke Skywalker", "1 Baker st", "62344", "+(09)34534444", "ls@gmail.com");
INSERT INTO address (name, street, postcode, telephone, email) VALUES ("Darth Vader", null, null, "+(09)42344333", null);

INSERT INTO credit_card (number, exp_date, name, type) VALUES ("xxx-xxx-xxxx-6345", "22/22", "JJ Binks", "VISA");
INSERT INTO credit_card (number, exp_date, name, type) VALUES ("xxx-xxx-xxxx-6323", "12/24", "P Leah", "MASTERCARD");

INSERT INTO users (id, userName, password, role) VALUES ("a", "admin", "2C26B46B68FFC68FF99B453C1D30413413422D706483BFA0F98A5E886266E7AE", "ROLE_ADMIN");
INSERT INTO users (id, userName, password, role) VALUES ("b", "user", "2C26B46B68FFC68FF99B453C1D30413413422D706483BFA0F98A5E886266E7AE", "ROLE_USER");
INSERT INTO users (id, userName, password, role) VALUES ("c", "foo", "2C26B46B68FFC68FF99B453C1D30413413422D706483BFA0F98A5E886266E7AE", "ROLE_USER");

INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("Limit Session IPA", 7.50, "main", "beer.png", 2);
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("Idaho NE Pale Ale", 4.50, "main", "beer.png", 2);
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("Eclipse Black IPA", 3.50, "main", "beer.png", 2);
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("NEW Release! Outer Limit Session IPA", 1.50, "main", "beer.png", 2);
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("Trailblazer Table Beer", 4.50, "main", "beer.png", 2);
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("Escape English Special Bitter", 7.50, "main", "beer.png", 2);
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("Peak Seeker IPA", 8.50, "main", "beer.png", 2);
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("Pioneer Cream Ale", 4.50, "main", "beer.png", 2);
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("Pumpkin Ale", 4.50, "main", "beer.png", 2);
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("2L stainless steel growlers", 12.50, "main", "beer.png", 2);
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("T-Shirt", 12.50, "main", "beer.png", 2);
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("Beer Mats", 12.50, "main", "beer.png", 2);

# // save a few products
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("Lachs-Spinat-Lasagne", 10.90, "main", "pizza.png", 1);
INSERT INTO product (name, price, type, img_filename, company_id) VALUES ("Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree", 4.50, "main", "beer.png", 1);

INSERT INTO orders (order_date, order_delivery_type, order_payment_type, company_id, creditCardEntity_cc_id, addressEntity_id)
VALUES (123123123, "DELIVERY", "CARD", 1, 1, 1);


INSERT INTO orders_item (order_amount, orders_item, product_id) values ()

#     OrderItemEntity oi1 = new OrderItemEntity(p1, 99);
# OrderItemEntity oi2 = new OrderItemEntity(p2, 9);
#
# INSERT INTO orders (order_date, order_delivery_type, order_payment_type, company_id, creditCardEntity_cc_id, addressEntity_id)
# VALUES (123123123, "DELIVERY", "CARD", 1, 1, 1);









