SET MODE PostgreSQL;

CREATE DATABASE organisationalportal;

CREATE TABLE users (
id serial PRIMARY KEY,
name varchar,
position varchar,
role varchar,
departmentId int
);

CREATE TABLE departments (
id serial PRIMARY KEY,
name varchar,
description varchar,
number_employees int
);

CREATE TABLE news (
id serial PRIMARY KEY,
userId int,
content varchar,
postdate timestamp,
departmentId int,
type varchar
);

CREATE DATABASE organisationalportal_test WITH TEMPLATE organisationalportal;