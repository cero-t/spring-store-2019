CREATE TABLE order_info
(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(256),
  address VARCHAR(512),
  telephone VARCHAR(16),
  mail_address VARCHAR(256),
  card_number VARCHAR(32),
  card_expire VARCHAR(8),
  card_name VARCHAR(256),
  cart_id VARCHAR(32)
);

CREATE TABLE order_event
(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  order_id BIGINT,
  event_type VARCHAR(32),
  event_time TIMESTAMP
);
