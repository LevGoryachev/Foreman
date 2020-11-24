CREATE DATABASE foreman;

CREATE TABLE "construction"(
id SERIAL PRIMARY KEY,
codenumber VARCHAR(100) NOT NULL,
name VARCHAR(255) NOT NULL,
description TEXT,
UNIQUE (codenumber)
);

CREATE TABLE "material"(
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
um VARCHAR(25) NOT NULL,
unitweight_kg INTEGER,
notes TEXT,
UNIQUE (name)
);

CREATE TABLE "role"(
id SERIAL PRIMARY KEY,
rank VARCHAR(255) NOT NULL,
UNIQUE(rank)
);

CREATE TABLE "app_user"(
id SERIAL PRIMARY KEY,
firstname VARCHAR(255) NOT NULL,
middlename VARCHAR(255),
lastname VARCHAR(255) NOT NULL,
nickname VARCHAR(255),
password VARCHAR(255),
role_id INTEGER REFERENCES "role"(id) ON DELETE SET NULL,
UNIQUE (nickname)
);

CREATE TABLE "order"(
id SERIAL,
construction_id INTEGER NOT NULL REFERENCES construction(id) ON DELETE SET NULL,
ordertime TIMESTAMP,
deliveredstatus BOOLEAN NOT NULL DEFAULT false,
app_user_id INTEGER NOT NULL REFERENCES "app_user"(id) ON DELETE SET NULL,
PRIMARY KEY (construction_id, id)
);

CREATE TABLE "billposition"(
construction_id INTEGER REFERENCES construction(id) ON DELETE CASCADE,
material_id INTEGER REFERENCES material(id) ON DELETE SET NULL,
billqty INTEGER NOT NULL,
PRIMARY KEY(construction_id, material_id),
CHECK (billqty > 0)
);

CREATE TABLE "orderposition"(
construction_id INTEGER,
material_id INTEGER,
order_id INTEGER,
FOREIGN KEY  (construction_id, order_id) REFERENCES "order" (construction_id, id) ON DELETE CASCADE,
FOREIGN KEY  (construction_id, material_id) REFERENCES "billposition" (construction_id, material_id) ON DELETE SET NULL,
PRIMARY KEY (construction_id, material_id, order_id),
orderqty INTEGER NOT NULL,
CHECK (orderqty > 0)
);