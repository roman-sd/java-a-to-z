SELECT p.id, p.name, to_char(p.expired_date, 'dd/mm/yy') AS expired_date, t.name AS type FROM product p, type t 
WHERE  p.type_id = t.id AND t.name = 'cheese';

SELECT p.id, p.name, to_char(p.expired_date, 'dd/mm/yy') AS expired_date, t.name AS type FROM product p, type t
WHERE p.type_id = t.id AND p.name = 'parmalat';

SELECT p.id, p.name, to_char(p.expired_date, 'dd/mm/yy') AS expired_date, t.name AS type FROM product p, type t 
WHERE p.type_id = t.id AND date_trunc('month', CURRENT_TIMESTAMP + INTERVAL '2' MONTH) > p.expired_date;

SELECT p.id, p.name, p.price, t.name FROM product p, type t
WHERE p.type_id = t.id AND price = (SELECT max(price) FROM product);

SELECT t.name, COUNT(p.id) FROM type t, product p
WHERE p.type_id = t.id 
GROUP BY t.id; 

SELECT p.name, t.name AS type FROM product p, type t 
WHERE p.type_id = t.id 
AND (t.name = 'milk' OR t.name = 'cheese')
ORDER BY t.name;

SELECT p.name, t.name AS type, p.num as num FROM product p, type t 
WHERE p.type_id = t.id AND p.num < 10;

SELECT p.name, to_char(p.expired_date, 'dd/mm/yy') AS expired_date, t.name AS type 
FROM product p, type t 
WHERE p.type_id = t.id
ORDER BY t.name;
