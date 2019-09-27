CREATE TABLE item
(
  id BIGINT NOT NULL PRIMARY KEY,
  name VARCHAR(64),
  media VARCHAR(32),
  author VARCHAR(64),
  unit_price NUMBER,
  release DATE,
  image VARCHAR(512)
);
