-- CREATE DATABASE "404rme"

CREATE TABLE role
(
    id_role SERIAL PRIMARY KEY,
    name    VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO role(name)
VALUES ('user'),
       ('admin');

CREATE TABLE "user"
(
    id_user         SERIAL PRIMARY KEY,
    uuid            UUID    DEFAULT gen_random_uuid() NOT NULL UNIQUE,
    username        VARCHAR(50)                       NOT NULL UNIQUE,
    email           VARCHAR(100)                      NOT NULL UNIQUE,
    hashed_password BYTEA                             NOT NULL,
    salt            BYTEA                             NOT NULL,
    role_id         INTEGER DEFAULT 1                 NOT NULL REFERENCES role (id_role)
);