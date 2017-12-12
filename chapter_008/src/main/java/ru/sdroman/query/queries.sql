SELECT p.name, to_char(expired_date, 'dd/mm/yy') AS "expired date", p.price, t.name AS type 
FROM product p JOIN type t ON p.type_id = t.id
WHERE t.name = 'cheese';

SELECT p.name, t.name AS type
FROM product p JOIN type t ON p.type_id = t.id
WHERE p.name like '%apple%';

SELECT p.name, to_char(expired_date, 'dd/mm/yy') AS "expired date", p.price, t.name AS type 
FROM product p JOIN type t ON p.type_id = t.id
WHERE date_trunc('month', CURRENT_TIMESTAMP + INTERVAL '2' month) > p.expired_date;

SELECT p.id, p.name, p.price, t.name FROM product p, type t
WHERE p.type_id = t.id AND price = (SELECT max(price) FROM product);

SELECT p.name, to_char(expired_date, 'dd/mm/yy') AS "expired date", p.price, t.name AS type 
FROM product p JOIN type t ON p.type_id = t.id
WHERE date_trunc('month', CURRENT_TIMESTAMP + INTERVAL '2' month) > p.expired_date;

SELECT p.name, t.name AS "type", p.num AS "number"
FROM product p JOIN type t ON p.type_id = t.id 
WHERE p.num < 10
ORDER BY t.name;

SELECT p.name, t.name AS "type"
FROM product p JOIN type t ON p.type_id = t.id
WHERE t.name = 'milk' OR t.name = 'cheese';

SELECT p.id, p.name, t.name AS type, to_char(p.expired_date, 'dd/mm/yy') AS "expiried date", p.num AS "number"
FROM product p JOIN type t ON p.type_id = t.id;
