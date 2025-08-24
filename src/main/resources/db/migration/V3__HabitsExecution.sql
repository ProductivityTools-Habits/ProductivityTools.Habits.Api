CREATE TABLE IF NOT EXISTS habitsexecution
(
    id                   SERIAL PRIMARY KEY,
    habitId              INT NOT NULL,
    status               BIT
);

ALTER TABLE habitsexecution ADD CONSTRAINT fk_habitsexecution_habits FOREIGN KEY (habitId) REFERENCES habits(id);

