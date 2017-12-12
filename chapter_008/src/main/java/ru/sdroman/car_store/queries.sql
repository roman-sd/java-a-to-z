SELECT c.name AS "auto", e.name AS "engine", t.name AS "transmission", b.name AS "car body" 
FROM car c JOIN engine e ON c.engine_id = e.id 
JOIN transmission t ON c.transmission_id = t.id
JOIN car_body b ON c.carbody_id = b.id; 

SELECT e.name AS "engine"
FROM car c RIGHT JOIN engine e ON c.engine_id = e.id 
WHERE c.engine_id is NULL;

SELECT t.name AS "transmission"
FROM transmission t LEFT JOIN car c ON c.transmission_id = t.id
WHERE c.transmission_id is NULL;

SELECT b.name AS "car body"
FROM car_body b LEFT OUTER JOIN car c ON c.carbody_id = b.id
WHERE c.carbody_id is NULL;   