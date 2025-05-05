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

CREATE TABLE product
(
    id             BIGINT PRIMARY KEY NOT NULL,
    price          DECIMAL(10, 2)     NOT NULL,
    shop_name      VARCHAR(255),
    coupon_price   DECIMAL(10, 2) DEFAULT 0.00,
    inventory      INTEGER        DEFAULT 0,
    title          TEXT,
    main_image_url TEXT
);

CREATE TABLE promotion_display
(
    id         SERIAL PRIMARY KEY,
    id_product BIGINT REFERENCES product (id),
    type_name  VARCHAR(255)
);

CREATE TABLE promotion_info
(
    id                   SERIAL PRIMARY KEY,
    id_promotion_display INTEGER REFERENCES promotion_display (id),
    activity_code        VARCHAR(255),
    promotion_name       TEXT
);

CREATE TABLE multi_language_info
(
    id         SERIAL PRIMARY KEY,
    id_product BIGINT REFERENCES product (id),
    language   VARCHAR(50) NOT NULL,
    title      TEXT        NOT NULL,
    UNIQUE (id_product, language)
);

-- Create indexes for better performance
CREATE INDEX idx_products_shop_name ON product (shop_name);
CREATE INDEX idx_products_price ON product (price);
CREATE INDEX idx_promotion_displays_product ON promotion_display (id_product);
CREATE INDEX idx_promotion_infos_display ON promotion_info (id_promotion_display);
CREATE INDEX idx_multi_language_product ON multi_language_info (id_product);

/*
delete from multi_language_info;
delete from promotion_display;
delete from product;
*/