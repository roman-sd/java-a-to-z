CREATE TABLE engine (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE transmission (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE car_body (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE car (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	engine_id INTEGER NOT NULL REFERENCES engine(id),
	transmission_id INTEGER NOT NULL REFERENCES transmission(id),
	carbody_id INTEGER NOT NULL REFERENCES car_body(id)
);