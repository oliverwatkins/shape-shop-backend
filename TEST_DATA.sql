
START TRANSACTION;

DELETE FROM product_category;
DELETE FROM orders_item;
DELETE FROM orders;
DELETE FROM product;
DELETE FROM users;
DELETE FROM credit_card;
DELETE FROM address;
DELETE FROM company;
DELETE FROM category;

INSERT INTO company (id, name) VALUES (1, "alpenhof");
INSERT INTO company (id, name) VALUES (2, "higgins");
INSERT INTO company (id, name) VALUES (3, "shapeshop");


INSERT INTO category (id, name, company_id) VALUES (1, "main", 1);
INSERT INTO category (id, name, company_id) VALUES (2, "drinks", 1);

INSERT INTO category (id, name, company_id) VALUES (3, "beers", 2);
INSERT INTO category (id, name, company_id) VALUES (4, "accessories", 2);

INSERT INTO category (id, name, company_id) VALUES (5, "squares", 3);
INSERT INTO category (id, name, company_id) VALUES (6, "triangles", 3);
INSERT INTO category (id, name, company_id) VALUES (7, "3D", 3);


# INSERT INTO category (cat_id, name, company_id) VALUES (4, "prodType2_", 2);

INSERT INTO address (id, name, street, postcode, telephone, email) VALUES (1, "Jar Jar Binks", "Bluw Lane Hwy 12", "41412", "+(09)928423444", "jj@gmail.com");
INSERT INTO address (id, name, street, postcode, telephone, email) VALUES (2, "Luke Skywalker", "1 Baker st", "62344", "+(09)34534444", "ls@gmail.com");
INSERT INTO address (id, name, street, postcode, telephone, email) VALUES (3, "Darth Vader", null, null, "+(09)42344333", null);

INSERT INTO credit_card (cc_id, number, exp_date, name, type) VALUES (1, "xxx-xxx-xxxx-6345", "22/22", "JJ Binks", "VISA");
INSERT INTO credit_card (cc_id, number, exp_date, name, type) VALUES (2, "xxx-xxx-xxxx-6323", "12/24", "P Leah", "MASTERCARD");

INSERT INTO users (id, user_name, password, role) VALUES (1, "admin", "8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918", "ROLE_ADMIN");
INSERT INTO users (id, user_name, password, role) VALUES (2, "user", "04F8996DA763B7A969B1028EE3007569EAF3A635486DDAB211D512C85B9DF8FB", "ROLE_USER");
INSERT INTO users (id, user_name, password, role) VALUES (3, "foo", "2C26B46B68FFC68FF99B453C1D30413413422D706483BFA0F98A5E886266E7AE", "ROLE_USER");

# higgins
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (1, "Limit Session IPA", "Limit Session IPA", 7.50, "beer.png", 2);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (2, "Idaho NE Pale Ale", "Idaho NE Pale Ale", 4.50, "beer.png", 2);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (3, "Eclipse Black IPA", "Eclipse Black IPA", 3.50, "beer.png", 2);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (4, "Outer Limit Session IPA", "NEW Release! Outer Limit Session IPA", 1.50, "beer.png", 2);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (5, "Trailblazer Table Beer", "Trailblazer Table Beer", 4.50,  "beer.png", 2);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (6, "Escape English Special Bitter", "Escape English Special Bitter", 7.50, "beer.png", 2);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (7, "Peak Seeker IPA", "Peak Seeker IPA", 8.50, "beer.png", 2);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (8, "Pioneer Cream Ale", "Pioneer Cream Ale", 4.50, "beer.png", 2);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (9, "Pumpkin Ale", "Pumpkin Ale", 4.50,  "beer.png", 2);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (10, "growlers", "2L stainless steel growlers", 12.50, "growler.png", 2);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (11, "T-Shirt", "T-Shirt", 12.50, "tshirt.jpg", 2);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (12, "Beer Mats", "Beer Mats", 12.50, "beermat.png", 2);

# alpenhof
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (13, "Lachs-Lasagne", "Lachs-Spinat-Lasagne", 10.90, "lachs_spinat.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (14, "Calamari", "Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree", 4.50, "calamari.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (15, "Minestone", "Minestone - italienische Gemüsesuppe mit Basilikumpesto", 10.90, "minestrone.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (16, "Zucchiniroellchen", "Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln", 7.90, "zucchini_rolls.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (17, "Lasagna", "Lasagna Classica al Forno mit Hackfleisch", 10.90, "lasagne.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (18, "Ravioli", "Ravioli gefüllt mit Bärlauch und Ricotta in Zitronenbutter mit Spargel", 4.50, "ravioli.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (19, "Gnocchi", "Hausgemachte Rosmarin-Gnocchi mit Hirschragout", 10.90, "gnocchi.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (20, "Fritto misto di Verdura", "Fritto misto di Verdura – frittierter Blumenkohl, Zucchini, Champignons, Paprika, Aubergine und Artischockenherz mit Knoblauchmayonnaise und Kräuterkartoffeln", 4.50, "fritto.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (21, "Pizza 1", "Pizza mit grünem und Weißem Spargel und Kirschtomaten", 10.90, "pizza_spargel.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (22, "Pizza 2", "Pizza mit Mortadella, Burrata und Trüffelcreme", 4.50, "pizza_mort.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (23, "Pizza 3", "Pizza mit Kirschtomaten, Burrata und Basilikum-Pesto", 13.90, "pizza_cherry.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (24, "Saltimbocca", "Saltimbocca alla Romana – Kalbslendenmedaillons mit Salbei und Parmaschinken in Weißweinsauce, dazu Kartoffel-Gemüse-Gratin", 13.90, "veal_parma.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (25, "Gegrillte Spiesse ", "Gegrillte Spieße mit Salsiccia, Hähnchenbrust, Rinderlende und Zwiebeln, dazu hausgemachte Barbecuesauce und Kräuterkartoffeln", 13.90, "spiesse.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (26, "Fritto Misto di Pesce", "Fritto Misto di Pesce -  frittierte Fische und Meeresfrüchte mit Knoblauch-Mayonnaise und Kräuterkartoffeln", 13.90, "grilledfish.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (27, "Erdbeersalat", "Mango-Panna Cotta mit Erdbeersalat", 4.50, "straw_salad.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (28, "Grillo", "Grillo ''Lustru'' IGP Cantine Europa, Sizilien 0,75 l", 16.30, "wine1.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (29, "Sauvignon", "Sauvignon ‘Matusin’ Walter Nardin, Veneto 0,75 l", 20.50, "wine2.JPG", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (30, "Grauburgunder Weingut", "Grauburgunder Weingut Braun, Pfalz 0,75 l", 22.70, "wine3.jpg", 1);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (31, "Lugana Villa", "Lugana Villa Trendi, Gardasee 0,75 l", 22.70, "wine4.jpg", 1);

# shapeshop
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (32, "Blue Square", "A nice blue square", 12.50, "blue_square.png", 3);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (33, "Dark Green Square", "A green square", 12.50, "darkgreen_square.png", 3);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (34, "Ligh Green Square", "A green square, but very light", 12.50, "lightgreen_square.png", 3);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (35, "Orange Square", "an orange square", 12.50, "orange_square.png", 3);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (36, "Rounded green square", "green square but rounded", 12.50, "green_rounded_square.png", 3);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (37, "Rounded pink square", "pink square but rounded", 12.50, "pink_rounded_square.png", 3);

INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (38, "brown triangle", "a brown triangle done in an arty style", 12.50, "triangle.png", 3);

INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (39, "3d_box", "a 3d box", 12.50, "3d_box.png", 3);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (40, "cylinder", "a nice cylinder", 12.50, "cylinder_bluepng.png", 3);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (41, "purple pyramid", "a striking purple pyramid", 12.50, "purple_pyramid.png", 3);




INSERT INTO orders (id, state, date, delivery_type, payment_type, company_id, credit_card_entity_cc_id, address_entity_id)
VALUES (1, 0, 123123123, 1, 1, 1, 1, 1);

INSERT INTO orders_item (order_amount, order_id, product_id) values (2, 1, 1);

INSERT INTO product_category (product_id, category_id) values (1, 3);
INSERT INTO product_category (product_id, category_id) values (2, 3);
INSERT INTO product_category (product_id, category_id) values (3, 3);
INSERT INTO product_category (product_id, category_id) values (4, 3);
INSERT INTO product_category (product_id, category_id) values (5, 3);
INSERT INTO product_category (product_id, category_id) values (6, 3);
INSERT INTO product_category (product_id, category_id) values (7, 3);
INSERT INTO product_category (product_id, category_id) values (8, 3);
INSERT INTO product_category (product_id, category_id) values (9, 3);
INSERT INTO product_category (product_id, category_id) values (10, 4);
INSERT INTO product_category (product_id, category_id) values (11, 4);
INSERT INTO product_category (product_id, category_id) values (12, 4);

INSERT INTO product_category (product_id, category_id) values (13, 1);
INSERT INTO product_category (product_id, category_id) values (14, 1);
INSERT INTO product_category (product_id, category_id) values (15, 1);
INSERT INTO product_category (product_id, category_id) values (16, 1);
INSERT INTO product_category (product_id, category_id) values (17, 1);
INSERT INTO product_category (product_id, category_id) values (18, 1);
INSERT INTO product_category (product_id, category_id) values (19, 1);
INSERT INTO product_category (product_id, category_id) values (20, 1);
INSERT INTO product_category (product_id, category_id) values (21, 1);
INSERT INTO product_category (product_id, category_id) values (22, 1);
INSERT INTO product_category (product_id, category_id) values (23, 1);
INSERT INTO product_category (product_id, category_id) values (24, 1);
INSERT INTO product_category (product_id, category_id) values (25, 1);
INSERT INTO product_category (product_id, category_id) values (26, 1);
INSERT INTO product_category (product_id, category_id) values (27, 1);

INSERT INTO product_category (product_id, category_id) values (28, 2);
INSERT INTO product_category (product_id, category_id) values (29, 2);
INSERT INTO product_category (product_id, category_id) values (30, 2);
INSERT INTO product_category (product_id, category_id) values (31, 2);

#shape shop
INSERT INTO product_category (product_id, category_id) values (32, 5);
INSERT INTO product_category (product_id, category_id) values (33, 5);
INSERT INTO product_category (product_id, category_id) values (34, 5);
INSERT INTO product_category (product_id, category_id) values (35, 5);
INSERT INTO product_category (product_id, category_id) values (36, 5);
INSERT INTO product_category (product_id, category_id) values (37, 5);

INSERT INTO product_category (product_id, category_id) values (38, 6);

INSERT INTO product_category (product_id, category_id) values (39, 7);
INSERT INTO product_category (product_id, category_id) values (40, 7);
INSERT INTO product_category (product_id, category_id) values (41, 7);

COMMIT;


#     OrderItemEntity oi1 = new OrderItemEntity(p1, 99);
# OrderItemEntity oi2 = new OrderItemEntity(p2, 9);
#
# INSERT INTO orders (order_date, order_delivery_type, order_payment_type, company_id, credit_card_entity_cc_id, addressEntity_id)
# VALUES (123123123, "DELIVERY", "CARD", 1, 1, 1);









