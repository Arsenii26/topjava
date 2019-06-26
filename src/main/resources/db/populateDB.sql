DELETE FROM user_roles;
DELETE FROM users;
-- DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;
-- ALTER SEQUENCE global_seq_meals RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

-- INSERT INTO meals (datetime, description, calories) VALUES
--   ('15-mar-2013 17:03:35', 'Kartoshka', 888),
--   ('12-apr-2013 15:13:25', 'Carrot', 777),
--   ('14-mar-2013 12:43:45', 'Steak', 1888);
--   (convert(datetime,'19-06-02 10:34:09 PM',5), 'Kartoshka', 888),
--   (convert(datetime,'15-08-12 11:34:09 PM',5), 'Carrot', 777),
--   (convert(datetime,'18-07-22 10:34:09 PM',5), 'Steak', 1888);