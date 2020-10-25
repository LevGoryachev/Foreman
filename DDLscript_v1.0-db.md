v1.0-db
DDL script

CREATE DATABASE foreman;

CREATE TABLE "construction"(
id SERIAL PRIMARY KEY,
codenumber VARCHAR(100) NOT NULL,
name VARCHAR(255) NOT NULL,
description TEXT
);

CREATE TABLE "material"(
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
um VARCHAR(25) NOT NULL,
unitweight_kg INTEGER,
notes TEXT
);

CREATE TABLE "user"(
id SERIAL PRIMARY KEY,
firstname VARCHAR(255) NOT NULL,
middlename VARCHAR(255),
lastname VARCHAR(255) NOT NULL,
nickname VARCHAR(255),
role VARCHAR(50) NOT NULL
);

CREATE TABLE "order"(
id SERIAL PRIMARY KEY,
ordertime TIMESTAMP,
status VARCHAR(50),
user_id INTEGER REFERENCES "user"(id) ON DELETE SET NULL
);


CREATE TABLE "billposition"(
construction_id INTEGER REFERENCES construction(id) ON DELETE CASCADE,
material_id INTEGER REFERENCES material(id) ON DELETE SET NULL,
billqty INTEGER NOT NULL,
PRIMARY KEY(construction_id, material_id)
);


CREATE TABLE "orderposition"(
construction_id INTEGER,
material_id INTEGER,
order_id INTEGER REFERENCES "order"(id) ON DELETE CASCADE, 
FOREIGN KEY  (construction_id, material_id) REFERENCES billposition (construction_id, material_id) ON DELETE SET NULL,
PRIMARY KEY (construction_id, material_id, order_id),
orderqty INTEGER NOT NULL
);