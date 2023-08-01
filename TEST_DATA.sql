
START TRANSACTION;

DELETE FROM product_category;
DELETE FROM orders_item;
DELETE FROM orders;
DELETE FROM product;
DELETE FROM users;
DELETE FROM credit_card;
DELETE FROM address;
DELETE FROM category;
DELETE FROM company;

SET @shapeshopid = 10;
SET @alpenhofid = 20;
SET @higginsid = 30;

SET @alpenhof_main = 200;
SET @alpenhof_drinks = 210;

SET @higgins_beer = 300;
SET @higgins_accessories = 310;

SET @shapeshop_squares = 100;
SET @shapeshop_triangles = 110;
SET @shapeshop_circles = 120;

INSERT INTO company (id, name) VALUES (@shapeshopid, "shapeshop");
INSERT INTO company (id, name) VALUES (@alpenhofid, "alpenhof");
INSERT INTO company (id, name) VALUES (@higginsid, "higgins");

INSERT INTO category (id, name, company_id) VALUES (@alpenhof_main, "main", @alpenhofid);
INSERT INTO category (id, name, company_id) VALUES (@alpenhof_drinks, "drinks", @alpenhofid);

INSERT INTO category (id, name, company_id) VALUES (@higgins_beer, "beers", @higginsid);
INSERT INTO category (id, name, company_id) VALUES (@higgins_accessories, "accessories", @higginsid);

INSERT INTO category (id, name, company_id) VALUES (@shapeshop_squares, "squares", @shapeshopid );
INSERT INTO category (id, name, company_id) VALUES (@shapeshop_triangles, "triangles", @shapeshopid );
INSERT INTO category (id, name, company_id) VALUES (@shapeshop_circles, "circle", @shapeshopid );


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
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (301, "Limit Session IPA", "Limit Session IPA", 7.50, "beer.png", @higginsid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (302, "Idaho NE Pale Ale", "Idaho NE Pale Ale", 4.50, "beer.png", @higginsid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (303, "Eclipse Black IPA", "Eclipse Black IPA", 3.50, "beer.png", @higginsid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (304, "Outer Limit Session IPA", "NEW Release! Outer Limit Session IPA", 1.50, "beer.png", @higginsid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (305, "Trailblazer Table Beer", "Trailblazer Table Beer", 4.50,  "beer.png", @higginsid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (306, "Escape English Special Bitter", "Escape English Special Bitter", 7.50, "beer.png", @higginsid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (307, "Peak Seeker IPA", "Peak Seeker IPA", 8.50, "beer.png", @higginsid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (308, "Pioneer Cream Ale", "Pioneer Cream Ale", 4.50, "beer.png", @higginsid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (309, "Pumpkin Ale", "Pumpkin Ale", 4.50,  "beer.png", @higginsid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (310, "growlers", "2L stainless steel growlers", 12.50, "growler.png", @higginsid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (311, "T-Shirt", "T-Shirt", 12.50, "tshirt.jpg", @higginsid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (312, "Beer Mats", "Beer Mats", 12.50, "beermat.png", @higginsid);

# alpenhof
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (213, "Lachs-Lasagne", "Lachs-Spinat-Lasagne", 10.90, "lachs_spinat.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (214, "Calamari", "Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree", 4.50, "calamari.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (215, "Minestone", "Minestone - italienische Gemüsesuppe mit Basilikumpesto", 10.90, "minestrone.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (216, "Zucchiniroellchen", "Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln", 7.90, "zucchini_rolls.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (217, "Lasagna", "Lasagna Classica al Forno mit Hackfleisch", 10.90, "lasagne.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (218, "Ravioli", "Ravioli gefüllt mit Bärlauch und Ricotta in Zitronenbutter mit Spargel", 4.50, "ravioli.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (219, "Gnocchi", "Hausgemachte Rosmarin-Gnocchi mit Hirschragout", 10.90, "gnocchi.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (220, "Fritto misto di Verdura", "Fritto misto di Verdura – frittierter Blumenkohl, Zucchini, Champignons, Paprika, Aubergine und Artischockenherz mit Knoblauchmayonnaise und Kräuterkartoffeln", 4.50, "fritto.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (221, "Pizza 1", "Pizza mit grünem und Weißem Spargel und Kirschtomaten", 10.90, "pizza_spargel.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (222, "Pizza 2", "Pizza mit Mortadella, Burrata und Trüffelcreme", 4.50, "pizza_mort.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (223, "Pizza 3", "Pizza mit Kirschtomaten, Burrata und Basilikum-Pesto", 13.90, "pizza_cherry.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (224, "Saltimbocca", "Saltimbocca alla Romana – Kalbslendenmedaillons mit Salbei und Parmaschinken in Weißweinsauce, dazu Kartoffel-Gemüse-Gratin", 13.90, "veal_parma.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (225, "Gegrillte Spiesse ", "Gegrillte Spieße mit Salsiccia, Hähnchenbrust, Rinderlende und Zwiebeln, dazu hausgemachte Barbecuesauce und Kräuterkartoffeln", 13.90, "spiesse.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (226, "Fritto Misto di Pesce", "Fritto Misto di Pesce -  frittierte Fische und Meeresfrüchte mit Knoblauch-Mayonnaise und Kräuterkartoffeln", 13.90, "grilledfish.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (227, "Erdbeersalat", "Mango-Panna Cotta mit Erdbeersalat", 4.50, "straw_salad.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (228, "Grillo", "Grillo ''Lustru'' IGP Cantine Europa, Sizilien 0,75 l", 16.30, "wine1.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (229, "Sauvignon", "Sauvignon ‘Matusin’ Walter Nardin, Veneto 0,75 l", 20.50, "wine2.JPG", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (230, "Grauburgunder Weingut", "Grauburgunder Weingut Braun, Pfalz 0,75 l", 22.70, "wine3.jpg", @alpenhofid);
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (231, "Lugana Villa", "Lugana Villa Trendi, Gardasee 0,75 l", 22.70, "wine4.jpg", @alpenhofid);

# shapeshop
#squares (32 - 39)
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (132, "Yellow Square", "Calm cool yellow square", 12.50, "square1.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (133, "Blue Square", "A green square", 12.50, "square2.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (134, "Green square", "Thoughtful and inquisitive, but has a shadow side", 12.50, "square3.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (135, "Brown Square", "Big hearted and always center of attention", 12.50, "square4.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (136, "Orange Square ", "Bordered", 12.50, "square5.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (137, "Rounded Blue Square", "blue", 12.50, "square6.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (138, "Pink rounde dsquare", "pink square but rounded pink square but rounded", 12.50, "square7.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (139, "Pink rounde dsquare", "pink square but rounded pink square but rounded", 12.50, "square8.png", @shapeshopid );

#triangles (40 - 45)
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (140, "brown triangle", "a brown triangle done in an arty style", 12.50, "triangle1.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (141, "brown triangle2", "a brown triangle done in an arty style", 12.50, "triangle2.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (142, "brown triangle3", "a brown triangle done in an arty style", 12.50, "triangle3.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (143, "brown triangle4", "a brown triangle done in an arty style", 12.50, "triangle4.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (144, "brown triangle5", "a brown triangle done in an arty style", 12.50, "triangle5.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (145, "brown triangle6", "a brown triangle done in an arty style", 12.50, "triangle6.png", @shapeshopid );

# circles (46 - 53)
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (146, "circle ", "a 3d box", 12.50, "circle1.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (147, "cylinder", "a nice cylinder", 12.50, "circle2.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (148, "purple pyramid", "a striking purple pyramid", 12.51, "circle3.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (149, "purple pyramid", "a striking purple pyramid", 13.50, "circle4.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (150, "purple pyramid", "a striking purple pyramid", 14.50, "circle5.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (151, "purple pyramid", "a striking purple pyramid", 1.50, "circle6.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (152, "purple pyramid", "a striking purple pyramid", 2.50, "circle7.png", @shapeshopid );
INSERT INTO product (id, name, description, price, img_filename, company_id) VALUES (153, "purple pyramid", "a striking purple pyramid", 3.50, "circle8.png", @shapeshopid );




INSERT INTO orders (id, state, date, delivery_type, payment_type, company_id, credit_card_entity_cc_id, address_entity_id)
VALUES (1, 0, 123123123, 1, 1, @alpenhofid, 1, 1);

INSERT INTO orders_item (order_amount, order_id, product_id) values (2, 1, 213);

#alpenhof
INSERT INTO product_category (product_id, category_id) values (213, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (214, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (215, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (216, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (217, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (218, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (219, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (220, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (221, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (222, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (223, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (224, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (225, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (226, @alpenhof_main);
INSERT INTO product_category (product_id, category_id) values (227, @alpenhof_main);

INSERT INTO product_category (product_id, category_id) values (228, @alpenhof_drinks);
INSERT INTO product_category (product_id, category_id) values (229, @alpenhof_drinks);
INSERT INTO product_category (product_id, category_id) values (230, @alpenhof_drinks);
INSERT INTO product_category (product_id, category_id) values (231, @alpenhof_drinks);


#shape shop
INSERT INTO product_category (product_id, category_id) values (132, @shapeshop_squares);
INSERT INTO product_category (product_id, category_id) values (133, @shapeshop_squares);
INSERT INTO product_category (product_id, category_id) values (134, @shapeshop_squares);
INSERT INTO product_category (product_id, category_id) values (135, @shapeshop_squares);
INSERT INTO product_category (product_id, category_id) values (136, @shapeshop_squares);
INSERT INTO product_category (product_id, category_id) values (137, @shapeshop_squares);
INSERT INTO product_category (product_id, category_id) values (138, @shapeshop_squares);
INSERT INTO product_category (product_id, category_id) values (139, @shapeshop_squares);

INSERT INTO product_category (product_id, category_id) values (140, @shapeshop_triangles);
INSERT INTO product_category (product_id, category_id) values (141, @shapeshop_triangles);
INSERT INTO product_category (product_id, category_id) values (142, @shapeshop_triangles);
INSERT INTO product_category (product_id, category_id) values (143, @shapeshop_triangles);
INSERT INTO product_category (product_id, category_id) values (144, @shapeshop_triangles);
INSERT INTO product_category (product_id, category_id) values (145, @shapeshop_triangles);

INSERT INTO product_category (product_id, category_id) values (146, @shapeshop_circles);
INSERT INTO product_category (product_id, category_id) values (147, @shapeshop_circles);
INSERT INTO product_category (product_id, category_id) values (148, @shapeshop_circles);
INSERT INTO product_category (product_id, category_id) values (149, @shapeshop_circles);
INSERT INTO product_category (product_id, category_id) values (150, @shapeshop_circles);
INSERT INTO product_category (product_id, category_id) values (151, @shapeshop_circles);
INSERT INTO product_category (product_id, category_id) values (152, @shapeshop_circles);
INSERT INTO product_category (product_id, category_id) values (153, @shapeshop_circles);

COMMIT;


#     OrderItemEntity oi1 = new OrderItemEntity(p1, 99);
# OrderItemEntity oi2 = new OrderItemEntity(p2, 9);
#
# INSERT INTO orders (order_date, order_delivery_type, order_payment_type, company_id, credit_card_entity_cc_id, addressEntity_id)
# VALUES (123123123, "DELIVERY", "CARD", 1, 1, 1);









