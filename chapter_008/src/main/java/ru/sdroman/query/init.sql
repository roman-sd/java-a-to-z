INSERT INTO type (name) VALUES ('cheese'), ('milk'), ('fruits');

INSERT INTO product (name, type_id, expired_date, price,  num) 
VALUES ('apple', 3, CURRENT_TIMESTAMP + INTERVAL '1' MONTH, 10.5, 35);

INSERT INTO product (name, type_id, expired_date, price, num) 
VALUES ('parmalat', 2, CURRENT_TIMESTAMP + INTERVAL '1' MONTH, 3.5, 20);

INSERT INTO product (name, type_id, expired_date, price, num) 
VALUES ('pineapple', 3, CURRENT_TIMESTAMP + INTERVAL '6' MONTH, 17.1, 5);

INSERT INTO product (name, type_id, expired_date, price, num) 
VALUES ('oris', 2, CURRENT_TIMESTAMP + INTERVAL '5' DAY, 5.1, 25); 

INSERT INTO product (name, type_id, expired_date, price, num) 
VALUES ('eila', 2, CURRENT_TIMESTAMP + INTERVAL '25' DAY, 3.7, 9);

INSERT INTO product (name, type_id, expired_date, price, num) 
VALUES ('artequeso', 1, CURRENT_TIMESTAMP + INTERVAL '3' MONTH, 14.9, 3);

INSERT INTO product (name, type_id, expired_date, price, num) 
VALUES ('boffard', 1, CURRENT_TIMESTAMP + INTERVAL '2' MONTH, 22.3, 5);
