DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    user_id bigserial PRIMARY KEY,
    user_name varchar(128) NOT NULL,
    user_birth_date date NOT NULL
);