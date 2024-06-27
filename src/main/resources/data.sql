INSERT INTO azerty (id, username, email, password, firstname, lastname) VALUES
    (1, 'default', 'default@default.fr', '$2a$10$D6tBTBdZiKyt8bP.1I/iV.8HLHbqBaUnx20ybU.DdiYkSAQPzlAN2', 'Chloe', 'Davis'),
    (2, 'awilliams', 'awilliams@default.fr', '$2a$10$D6tBTBdZiKyt8bP.1I/iV.8HLHbqBaUnx20ybU.DdiYkSAQPzlAN2', 'Alexandra', 'Williams'),
    (100, 'tanderson', 'tanderson@default.fr', '$2a$10$D6tBTBdZiKyt8bP.1I/iV.8HLHbqBaUnx20ybU.DdiYkSAQPzlAN2', 'Thomas', 'Anderson'),
    (101, 'bclarkson', 'bclarkson@default.fr', '$2a$10$D6tBTBdZiKyt8bP.1I/iV.8HLHbqBaUnx20ybU.DdiYkSAQPzlAN2', 'Benjamin', 'Clarkson'),
    (103, 'ithompson', 'ithompson@default.fr', '$2a$10$D6tBTBdZiKyt8bP.1I/iV.8HLHbqBaUnx20ybU.DdiYkSAQPzlAN2', 'Isabella', 'Thompson'),
    (402, 'mbrown', 'mbrown@default.fr', '$2a$10$D6tBTBdZiKyt8bP.1I/iV.8HLHbqBaUnx20ybU.DdiYkSAQPzlAN2', 'Matthew', 'Brown');


INSERT INTO qwerty (id, username, email, password, firstname, lastname, social_account) VALUES
    (2, '3xslkgt3', '3xslkgt3@default.fr', '$2a$10$y7UHu.Qn.1fcmCvc0OVJCelsBUXVOm.52/G32wHM8f5EuQmXBFDLW', 'Catriona', 'Davidson', '3xslkgt336970'),
    (3, '67zuNbpo', '67zuNbpo@default.fr', '$2a$10$y7UHu.Qn.1fcmCvc0OVJCelsBUXVOm.52/G32wHM8f5EuQmXBFDLW', 'Paul', 'Doubs', '67zuNbpo');

INSERT INTO fish (id, admin_id, question, answer) VALUES
    (1, 2, 'your favorite animal', 't-rex'),
    (2, 2, 'your favorite film', 'jurassic park'),
    (2, 2, 'your tel number', '07123'),
    (3, 3, 'your favorite hobby', 'walking'),
    (4, 3, 'your favorite actor', 'vin diesel'),
    (5, 3, 'your tel number', '078712')
    ;

INSERT INTO cat (id, follower_id, following_id) VALUES
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