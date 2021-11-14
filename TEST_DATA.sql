
START TRANSACTION;


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

INSERT INTO users (id, user_name, password, role) VALUES (1, "admin", "8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918", "ROLE_ADMIN");
INSERT INTO users (id, user_name, password, role) VALUES (2, "user", "04F8996DA763B7A969B1028EE3007569EAF3A635486DDAB211D512C85B9DF8FB", "ROLE_USER");
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
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (13, "Lachs-Spinat-Lasagne", 10.90, "main", "lachs_spinat.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (14, "Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree", 4.50, "main", "calamari.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (15, "MMinestone - italienische Gemüsesuppe mit Basilikumpesto", 10.90, "main", "minestrone.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (16, "Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln", 7.90, "main", "zucchini_rolls.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (17, "Lasagna Classica al Forno mit Hackfleisch", 10.90, "main", "lasagne.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (18, "Ravioli gefüllt mit Bärlauch und Ricotta in Zitronenbutter mit Spargel", 4.50, "main", "ravioli.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (19, "Hausgemachte Rosmarin-Gnocchi mit Hirschragout", 10.90, "main", "gnocchi.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (20, "Fritto misto di Verdura – frittierter Blumenkohl, Zucchini, Champignons, Paprika, Aubergine und Artischockenherz mit Knoblauchmayonnaise und Kräuterkartoffeln", 4.50, "main", "fritto.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (21, "Pizza mit grünem und Weißem Spargel und Kirschtomaten", 10.90, "main", "pizza_spargel.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (22, "Pizza mit Mortadella, Burrata und Trüffelcreme", 4.50, "main", "pizza_mort.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (23, "Pizza mit Kirschtomaten, Burrata und Basilikum-Pesto", 13.90, "main", "pizza_cherry.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (24, "Saltimbocca alla Romana – Kalbslendenmedaillons mit Salbei und Parmaschinken in Weißweinsauce, dazu Kartoffel-Gemüse-Gratin", 13.90, "main", "veal_parma.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (25, "Gegrillte Spieße mit Salsiccia, Hähnchenbrust, Rinderlende und Zwiebeln, dazu hausgemachte Barbecuesauce und Kräuterkartoffeln", 13.90, "main", "spiesse.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (26, "Fritto Misto di Pesce -  frittierte Fische und Meeresfrüchte mit Knoblauch-Mayonnaise und Kräuterkartoffeln", 13.90, "main", "grilledfish.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (27, "Mango-Panna Cotta mit Erdbeersalat", 4.50, "main", "straw_salad.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (28, "Grillo ''Lustru'' IGP Cantine Europa, Sizilien 0,75 l", 16.30, "drinks", "wine1.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (29, "Sauvignon ‘Matusin’ Walter Nardin, Veneto 0,75 l", 20.50, "drinks", "wine2.JPG", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (30, "Grauburgunder Weingut Braun, Pfalz 0,75 l", 22.70, "drinks", "wine3.jpg", 1);
INSERT INTO product (id, name, price, type, img_filename, company_id) VALUES (31, "Lugana Villa Trendi, Gardasee 0,75 l", 22.70, "drinks", "wine4.jpg", 1);










INSERT INTO orders (order_id, order_state, order_date, order_delivery_type, order_payment_type, company_id, credit_card_entity_cc_id, address_entity_id)
VALUES (1, 0, 123123123, 1, 1, 1, 1, 1);

INSERT INTO orders_item (order_amount, orders_item_id, product_id) values (2, 1, 1);



COMMIT;


#     OrderItemEntity oi1 = new OrderItemEntity(p1, 99);
# OrderItemEntity oi2 = new OrderItemEntity(p2, 9);
#
# INSERT INTO orders (order_date, order_delivery_type, order_payment_type, company_id, credit_card_entity_cc_id, addressEntity_id)
# VALUES (123123123, "DELIVERY", "CARD", 1, 1, 1);









