CREATE TABLE role (
  id SERIAL PRIMARY KEY,
  name VARCHAR(20)
);

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(20),
  login VARCHAR(20) UNIQUE ,
  password VARCHAR(20),
  email VARCHAR (50) UNIQUE ,
  createDate TIMESTAMP,
  role_id INTEGER REFERENCES role(id),
  country VARCHAR(20),
  city VARCHAR (20)
);