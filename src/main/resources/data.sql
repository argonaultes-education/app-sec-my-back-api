INSERT INTO std_users (id, username, email, password, firstname, lastname) VALUES
    (1, 'default', 'default@default.fr', 'Y2xlYXI=', 'Chloe', 'Davis'),
    (2, 'awilliams', 'awilliams@default.fr', 'Y2xlYXI=', 'Alexandra', 'Williams'),
    (3, 'tanderson', 'tanderson@default.fr', 'Y2xlYXI=', 'Thomas', 'Anderson'),
    (4, 'bclarkson', 'bclarkson@default.fr', 'Y2xlYXI=', 'Benjamin', 'Clarkson'),
    (5, 'ithompson', 'ithompson@default.fr', 'Y2xlYXI=', 'Isabella', 'Thompson'),
    (6, 'mbrown', 'mbrown@default.fr', 'Y2xlYXI=', 'Matthew', 'Brown');


INSERT INTO admin_users (id, username, email, password, firstname, lastname, x_account) VALUES
    (1, 'admin', 'admin@default.fr', '$2a$10$oYWSBAqNl4F.5vnIWW3lCepbd.o5Kz4FKdPhWQgKv8tBOUSZzBXdq', 'David', 'Martinez', null),
    (2, '3xslkgt3', '3xslkgt3@default.fr', '$2a$10$oYWSBAqNl4F.5vnIWW3lCepbd.o5Kz4FKdPhWQgKv8tBOUSZzBXdq', 'Catriona', 'Davidson', '3xslkgt336970');

INSERT INTO recover_questions (id, admin_id, question, answer) VALUES
    (1, 2, 'your favorite animal', 'horse'),
    (2, 2, 'your favorite sport', 'basket-ball');

INSERT INTO followings (id, follower_id, following_id) VALUES
    (1, 2, 3),
    (2, 2, 4),
    (3, 2, 5),
    (4, 5, 2),
    (5, 5, 6);


INSERT INTO positions (id, latitude, longitude, recorded_at, user_id) VALUES
    (1, 34.068795, -84.299412, '2020-10-10 10:00:01', 3),
    (2, 33.999201, -84.381247, '2020-10-10 11:00:01', 3),
    (3, 34.014047, -84.401869, '2020-10-10 12:00:01', 3),
    (4, 33.956111, -84.371392, '2020-10-10 13:00:01', 3),
    (5, 34.002114, -84.369241, '2020-10-10 14:00:01', 3);


INSERT INTO messages (id, message, author_id, recipient_id, send_at) VALUES
    (1, 'best party ever', 1, 2, '2020-10-10 10:00:00'),
    (2, 'how are you?', 1, 5, '2020-10-10 10:00:01'),
    (3, 'where are you?', 2, 6, '2020-10-10 10:00:02'),
    (4, 'give me one more chance', 2, 6, '2020-10-10 10:00:03');