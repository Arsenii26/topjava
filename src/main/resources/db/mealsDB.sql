DROP TABLE IF EXISTS meals;
DROP SEQUENCE IF EXISTS global_seq_meals;

CREATE SEQUENCE global_seq_meals START WITH 100000;

CREATE TABLE meals
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq_meals'),
  dateTime            TIMESTAMP                 NOT NULL,
  description         VARCHAR                 NOT NULL,
  calories         INTEGER NOT NULL

);