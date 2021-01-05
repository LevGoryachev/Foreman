CREATE TABLE "construction"(
id SERIAL PRIMARY KEY,
codenumber VARCHAR(25) NOT NULL,
name VARCHAR(80) NOT NULL,
description TEXT,
UNIQUE (codenumber),
UNIQUE (name),
CHECK (name !='')
);

CREATE TABLE "material"(
id SERIAL PRIMARY KEY,
name VARCHAR(80) NOT NULL,
um VARCHAR(25) NOT NULL,
unitweight_kg INTEGER,
notes TEXT,
UNIQUE (name)
);

CREATE TABLE "role"(
id SERIAL PRIMARY KEY,
rank VARCHAR(25) NOT NULL,
UNIQUE(rank),
CHECK (rank !='')
);

CREATE TABLE "app_user"(
id SERIAL PRIMARY KEY,
firstname VARCHAR(80) NOT NULL,
middlename VARCHAR(80),
lastname VARCHAR(80) NOT NULL,
login VARCHAR(25) NOT NULL,
password VARCHAR(255) NOT NULL,
email VARCHAR(80),
role_id INTEGER REFERENCES "role"(id) ON DELETE SET NULL,
UNIQUE (login),
CHECK (login !=''),
CHECK (password !='')
);

CREATE TABLE "billposition"(
construction_id INTEGER REFERENCES construction(id) ON DELETE CASCADE,
material_id INTEGER REFERENCES material(id) ON DELETE SET NULL,
billqty INTEGER NOT NULL,
PRIMARY KEY(construction_id, material_id),
CHECK (billqty >= 0)
);

CREATE TABLE "order"(
id SERIAL,
construction_id INTEGER NOT NULL REFERENCES construction(id) ON DELETE SET NULL,
ordertime TIMESTAMP,
posted BOOLEAN NOT NULL DEFAULT false,
sent BOOLEAN NOT NULL DEFAULT false,
status_executed BOOLEAN NOT NULL DEFAULT false,
app_user_id INTEGER NOT NULL REFERENCES "app_user"(id) ON DELETE SET NULL,
PRIMARY KEY (construction_id, id),
UNIQUE(id)
);

CREATE TABLE "orderposition"(
construction_id INTEGER,
material_id INTEGER,
order_id INTEGER,
FOREIGN KEY  (construction_id, order_id) REFERENCES "order" (construction_id, id) ON DELETE CASCADE,
FOREIGN KEY  (construction_id, material_id) REFERENCES "billposition" (construction_id, material_id) ON DELETE SET NULL,
PRIMARY KEY (construction_id, material_id, order_id),
status_delivered BOOLEAN NOT NULL DEFAULT false,
orderqty INTEGER NOT NULL,
CHECK (orderqty > 0)
);