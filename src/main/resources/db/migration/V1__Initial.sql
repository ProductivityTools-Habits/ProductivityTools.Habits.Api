CREATE TABLE IF NOT EXISTS person
(
    id                    SERIAL PRIMARY KEY,
    firstName             VARCHAR(255)      NOT NULL,
    LastName              VARCHAR(255)      NOT NULL
);