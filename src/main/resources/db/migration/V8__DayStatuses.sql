CREATE TABLE IF NOT EXISTS daystatuses
(
    id       SERIAL PRIMARY KEY,
    date     DATE         NOT NULL UNIQUE,
    status   VARCHAR(100) NOT NULL,
    reason   TEXT         NULL
);
