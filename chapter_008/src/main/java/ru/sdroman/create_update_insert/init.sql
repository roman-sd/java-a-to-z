INSERT INTO rules (name) VALUES ('root'), ('r/w'), ('readonly');

INSERT INTO roles (name) VALUES ('admin'), ('user'), ('guest');

INSERT INTO users (name, role_id) VALUES ('Alex', 2), ('Bart', 3), ('Alice', 1);

INSERT INTO roles_rules (role_id, rule_id) VALUES (1, 1), (2, 2), (3, 3);

INSERT INTO categories (name) VALUES ('Task'), ('Bug');

INSERT INTO states (name) VALUES ('Created'), ('In process'), ('Finished');

INSERT INTO items (name, user_id, category_id, state_id) VALUES ('item 1', 1, 2, 2), ('item 2', 2, 1, 1);

INSERT INTO comments (comment, item_id) VALUES ('Created', 1), ('Closed', 1), ('Success', 2);

INSERT INTO attach (name, item_id) VALUES ('file_01', 1), ('file_02', 2), ('file_03', 2);