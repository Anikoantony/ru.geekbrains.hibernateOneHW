DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Car', 8000), ('House', 100000), ('Boat', 5000);

DROP TABLE users IF EXISTS;
CREATE TABLE IF NOT EXISTS users (id bigserial, score int, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO users (name, score) VALUES ('Bob', 80), ('Jack', 80), ('John', 80);