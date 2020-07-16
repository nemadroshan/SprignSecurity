INSERT INTO users (username,password,enabled)
values ('Roshan','pass','true');

INSERT INTO users (username,password,enabled)
values ('Admin','pass','true');

INSERT INTO users (username,password,enabled)
values ('shubham','pass','true');

INSERT INTO authorities
(username,authority)values ('Roshan','ROLE_USER');

INSERT INTO
authorities (username,authority)values ('Admin','ROLE_ADMIN');

INSERT INTO
authorities (username,authority)values ('shubham','ROLE_USER');