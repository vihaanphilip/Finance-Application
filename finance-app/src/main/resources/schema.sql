CREATE TABLE IF NOT EXISTS account_type (
    id BIGINT PRIMARY KEY,
    label VARCHAR(500) NOT NULL,
    description VARCHAR(2000) NOT NULL
);

CREATE TABLE IF NOT EXISTS account (
    id BIGINT PRIMARY KEY,
    account_name VARCHAR(500) NOT NULL,
    account_type_id BIGINT NOT NULL
);