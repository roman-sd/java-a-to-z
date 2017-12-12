INSERT INTO engine(name) VALUES ('V6'), ('V8'), ('V12'), ('V16');

INSERT INTO transmission(name) VALUES ('manual'), ('automatic'), ('Continuously variable'), ('dual-clutch');

INSERT INTO car_body(name) VALUES ('sedan'), ('coupe'), ('sports car'), ('crossover'), ('truck');

INSERT INTO car(name, engine_id, transmission_id, carbody_id) VALUES ('Toyota', 1, 2, 1),
 ('BMW', 3, 4, 2), ('Mercedes', 3, 3, 4);