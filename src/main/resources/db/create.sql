CREATE DATABASE organisationals_portal;
\c organisationals_portal

CREATE TABLE departments (
id serial PRIMARY KEY,
name VARCHAR,
description VARCHAR
);


CREATE TABLE users (
id serial PRIMARY KEY,
name VARCHAR,
position VARCHAR,
role VARCHAR,
departmentId int
);

CREATE TABLE news (
id serial PRIMARY KEY,
userId int,
content varchar,
postdate timestamp,
departmentId int,
type varchar
);

CREATE DATABASE organisationals_portal_test WITH TEMPLATE organisationals_portal;