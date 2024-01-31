DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS "order" CASCADE;

CREATE TABLE user (
     id int(11) unsigned NOT NULL AUTO_INCREMENT,
     username varchar(20) NOT NULL DEFAULT '',
     password varchar(20) NOT NULL DEFAULT '',
     active tinyint(1) NOT NULL DEFAULT '1',
     roles varchar(200) NOT NULL DEFAULT '',
     permissions varchar(200) NOT NULL DEFAULT '',
     PRIMARY KEY (id)
);

CREATE TABLE items (
    itemId int(11) NOT NULL AUTO_INCREMENT,
    itemName varchar(255) NOT NULL DEFAULT '',
    quantity int(12) NOT NULL,
    price decimal(10, 2) NOT NULL
    PRIMARY KEY (itemId)
);

CREATE TABLE "order" (
    userid int(11) NOT NULL,
    orderId int(20) NOT NULL AUTO_INCREMENT,
    orderDate int(40) NOT NULL DEFAULT 0,
    shippingAddress varchar(200) NOT NULL DEFAULT '',
    totalPrice decimal(10, 2) NOT NULL,
    status varchar(20) NOT NULL,
    items varchar(255) NOT NULL,
    PRIMARY KEY (orderId)
);

INSERT INTO user (username, password, active, roles, permissions) VALUES
    ('dan', '1234', 1, '', ''),
    ('alon', '12345', 1, '', '');
INSERT INTO items (itemName, quantity, price) VALUES
    ('Air Filter', 10, 19.99),
    ('Front Bumper', 10, 19.99),
    ('Car Chair', 10, 19.99),
    ('Front Headlight', 10, 19.99),
    ('Middle Mirror', 10, 19.99),
    ('Oil Filter', 10, 19.99),
    ('Oil 5W40', 10, 19.99),
    ('Radiator', 10, 19.99),
    ('Rear Door', 10, 19.99),
    ('Side Mirror', 10, 19.99);


