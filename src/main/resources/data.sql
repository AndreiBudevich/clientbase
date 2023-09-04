INSERT INTO client (name, surname)
VALUES ('Андрей', 'Будевич'),
       ('Татьяна', 'Будевич'),
       ('Ксения', 'Будевич');

INSERT INTO contact (client_id, contact_type, contact_info)
VALUES (1, 'EMAIL', 'budevichac@gmail.com'),
       (1, 'PHONE_NUMBER', '+375297634349'),
       (2, 'PHONE_NUMBER', '+375447324144'),
       (3, 'EMAIL', 'budevichka@gmail.com');