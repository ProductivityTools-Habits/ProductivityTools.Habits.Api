ALTER TABLE habits ADD COLUMN createdat DATE;

-- Backfill: a habit is assumed to exist since its first recorded execution,
-- or since today if it was never executed.
UPDATE habits h
SET createdat = (SELECT MIN(e.date) FROM executions e WHERE e.habitid = h.id);

UPDATE habits SET createdat = CURRENT_DATE WHERE createdat IS NULL;

ALTER TABLE habits ALTER COLUMN createdat SET DEFAULT CURRENT_DATE;
ALTER TABLE habits ALTER COLUMN createdat SET NOT NULL;
