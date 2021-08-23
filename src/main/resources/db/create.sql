SET MODE PostgreSQL;

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
departmentId INTEGER
);

CREATE TABLE news (
id serial PRIMARY KEY,
user_id INTEGER,
title VARCHAR ,
content VARCHAR ,
departmentId INTEGER
);

CREATE DATABASE organisationals_portal_test WITH TEMPLATE organisationals_portal;